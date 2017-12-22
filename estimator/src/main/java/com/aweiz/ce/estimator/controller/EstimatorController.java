package com.aweiz.ce.estimator.controller;

import com.aweiz.ce.estimator.pojo.EstimationParam;
import com.aweiz.ce.estimator.service.AddressService;
import com.aweiz.ce.estimator.service.EstimatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstimatorController {

    private static final Logger logger = LoggerFactory.getLogger(EstimatorController.class);

    @Autowired
    private EstimatorService estimatorService;

    @PostMapping(value="/estimation")
    public ResponseEntity<Object> getEstimation(@RequestBody EstimationParam estParam){
        logger.debug("in estimatior controller with parameter:" + estParam);
        return new ResponseEntity<Object>(estimatorService.getEstimation(estParam), HttpStatus.OK);
    }

}
