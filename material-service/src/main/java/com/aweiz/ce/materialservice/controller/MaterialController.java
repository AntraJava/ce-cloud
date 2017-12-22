package com.aweiz.ce.materialservice.controller;

import com.aweiz.ce.materialservice.pojo.MaterialEstimation;
import com.aweiz.ce.materialservice.pojo.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class MaterialController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialController.class);
    @PostMapping(value = "/material/estimation")
    public MaterialEstimation estimateMaterial(@RequestBody List<Material> materialList){
        LOGGER.debug("Entered estimateMaterial controller with "+ materialList);
        MaterialEstimation est = new MaterialEstimation();

        Random random = new Random();
        est.setBreakdowns(materialList.stream().map(m -> {m.setPrice(random.nextDouble()*10000);return m;
        }).collect(Collectors.toList()));
        Double total = est.getBreakdowns().stream().reduce((e1, e2) -> {
            Material e = new Material();
            e.setPrice(e1.getPrice()*e1.getPrice() + e2.getPrice() * e2.getQuatity());
            return e;
        }).orElse(new Material()).getPrice();
        est.setTotalPrice(new BigDecimal(total).setScale(2, BigDecimal.ROUND_CEILING));
        LOGGER.debug("Get the estimation for materials "+ est.getTotalPrice());
        return est;
    }
}