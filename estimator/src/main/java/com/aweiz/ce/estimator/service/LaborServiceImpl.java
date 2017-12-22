package com.aweiz.ce.estimator.service;

import com.aweiz.ce.estimator.pojo.LaborEstimation;
import com.aweiz.ce.estimator.pojo.LaborEstimationParam;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LaborServiceImpl implements LaborService {

    private static final Logger logger = LoggerFactory.getLogger(LaborServiceImpl.class);
    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public LaborEstimation estimate(LaborEstimationParam param) {
        HttpEntity<LaborEstimationParam> entity = new HttpEntity<>(param);
        ResponseEntity<?> res = restTemplate.exchange("http://laborservice/labor/estimation",  HttpMethod.POST, entity, LaborEstimation.class);
        logger.info(res.toString());
        return (LaborEstimation)res.getBody();
    }

    public LaborEstimation fallbackMethod(LaborEstimationParam param, Throwable e) {
        logger.error("From REST - Something wrong in LaborServiceImpl - estimate, error is", e);
        LaborEstimation estimation = new LaborEstimation();
        estimation.setTotalPrice(new BigDecimal(0));
        return estimation;
    }
}
