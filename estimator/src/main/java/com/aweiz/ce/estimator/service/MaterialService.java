package com.aweiz.ce.estimator.service;

import com.aweiz.ce.estimator.pojo.Material;
import com.aweiz.ce.estimator.pojo.MaterialEstimation;

import java.util.List;

public interface MaterialService {
    public MaterialEstimation estimate(List<Material> materialList);
}
