package com.aweiz.ce.estimator.service;

import com.aweiz.ce.estimator.pojo.LaborEstimation;
import com.aweiz.ce.estimator.pojo.LaborEstimationParam;

public interface LaborService {
    LaborEstimation estimate(LaborEstimationParam param);
}
