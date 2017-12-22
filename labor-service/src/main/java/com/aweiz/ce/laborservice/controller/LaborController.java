package com.aweiz.ce.laborservice.controller;

import com.aweiz.ce.laborservice.pojo.LaborEstimation;
import com.aweiz.ce.laborservice.pojo.LaborEstimationParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class LaborController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LaborController.class);
    @PostMapping("/labor/estimation")
    public LaborEstimation estimate(@RequestBody LaborEstimationParam param) {
        LOGGER.debug("Entered estimate Labor controller with "+ param);
        LaborEstimation res = new LaborEstimation();
        res.setTotalPrice(new BigDecimal(40000));
        LOGGER.debug("The estimation of labor is:  "+ res.getTotalPrice());
        return res;
    }
}
