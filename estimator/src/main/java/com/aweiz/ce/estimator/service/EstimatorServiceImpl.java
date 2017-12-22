package com.aweiz.ce.estimator.service;

import com.aweiz.ce.estimator.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.*;

@Service
public class EstimatorServiceImpl implements EstimatorService {

    private static final Logger logger = LoggerFactory.getLogger(EstimatorServiceImpl.class);

    @Autowired
    AddressService addressService;

    @Autowired
    MaterialService materialService;

    @Autowired
    LaborService laborService;

    @Autowired
    ThreadPoolTaskExecutor es;


    public Estimation getEstimation2(EstimationParam param) {

        Estimation estimation = new Estimation();
        estimation.setAddress(addressService.verifyAddress(param.getAddress()));
        estimation.setMaterialEstimation(materialService.estimate(param.getMaterials()));

        LaborEstimationParam laborParam = new LaborEstimationParam();
        laborParam.setAddress(param.getAddress());
        laborParam.setSize(param.getSize());
        laborParam.setType(param.getType());
        estimation.setLaborEstimation(laborService.estimate(laborParam));
        return estimation;
    }

    public Estimation getEstimation1(EstimationParam param) {

        Future<String> addressFuture = es.submit(() -> addressService.verifyAddress(param.getAddress()));
        Future<MaterialEstimation> materialFuture = es.submit(() -> materialService.estimate(param.getMaterials()));

        LaborEstimationParam laborParam = new LaborEstimationParam();
        laborParam.setAddress(param.getAddress());
        laborParam.setSize(param.getSize());
        laborParam.setType(param.getType());
        Future<LaborEstimation> laborFuture = es.submit(() -> laborService.estimate(laborParam));

        Estimation estimation = new Estimation();
        try {
            estimation.setAddress(addressFuture.get());
            estimation.setMaterialEstimation(materialFuture.get());
            estimation.setLaborEstimation(laborFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("",e);
        } catch (ExecutionException e) {
            e.printStackTrace();
            logger.error("",e);
        }

        return estimation;
    }
    @Override // completable Future implementation
    public Estimation getEstimation(EstimationParam param) {
        Estimation estimation = new Estimation();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->addressService.verifyAddress(param.getAddress()), es);
        future.thenAccept(estimation::setAddress);
        CompletableFuture<MaterialEstimation> futureMatierla = CompletableFuture.supplyAsync(()->materialService.estimate(param.getMaterials()), es);
        futureMatierla.thenAccept(estimation::setMaterialEstimation);

        LaborEstimationParam laborParam = new LaborEstimationParam();
        laborParam.setAddress(param.getAddress());
        laborParam.setSize(param.getSize());
        laborParam.setType(param.getType());
        CompletableFuture<LaborEstimation> futureLabor = CompletableFuture.supplyAsync(()->laborService.estimate(laborParam), es);
        futureLabor.thenAccept(estimation::setLaborEstimation);

        try {
//            future.thenCombine(futureMatierla, (s, materialEstimation) -> estimation).thenCombine(futureLabor, (m, laborEstimation) -> estimation).get();
            CompletableFuture.allOf(future, futureMatierla, futureLabor).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("",e);
        } catch (ExecutionException e) {
            e.printStackTrace();
            logger.error("",e);
        }
        return estimation;
    }
}
