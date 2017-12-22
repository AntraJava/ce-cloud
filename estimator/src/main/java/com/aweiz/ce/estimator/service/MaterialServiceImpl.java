package com.aweiz.ce.estimator.service;

import com.aweiz.ce.estimator.pojo.Material;
import com.aweiz.ce.estimator.pojo.MaterialEstimation;
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
public class MaterialServiceImpl implements MaterialService {
    private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);
    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public MaterialEstimation estimate(List<Material> materialList) {
        HttpEntity<List<Material>> entity = new HttpEntity<>(materialList);
        ResponseEntity<?> res = restTemplate.exchange("http://materialservice/material/estimation",  HttpMethod.POST, entity, MaterialEstimation.class);
        logger.info(res.toString());
        return (MaterialEstimation)res.getBody();
    }

    public MaterialEstimation fallbackMethod(List<Material> materialList, Throwable e) {
        logger.error("From REST - Something wrong in MaterialService - estimate, error is", e);
        MaterialEstimation me = new MaterialEstimation();
        me.setTotalPrice(new BigDecimal(0));
        return me;
    }
}
