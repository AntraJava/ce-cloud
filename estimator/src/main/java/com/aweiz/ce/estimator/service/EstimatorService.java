package com.aweiz.ce.estimator.service;

import com.aweiz.ce.estimator.pojo.Estimation;
import com.aweiz.ce.estimator.pojo.EstimationParam;

public interface EstimatorService {
    public Estimation getEstimation(EstimationParam param);
}
