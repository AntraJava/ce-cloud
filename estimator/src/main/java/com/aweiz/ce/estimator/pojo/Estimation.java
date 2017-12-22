package com.aweiz.ce.estimator.pojo;

import java.math.BigDecimal;

public class Estimation {

    private String address;

    private MaterialEstimation materialEstimation;

    private LaborEstimation laborEstimation;

    public BigDecimal getGrandTotal() {
        BigDecimal total = new BigDecimal(1000);
        total = total.add(materialEstimation.getTotalPrice());
        total = total.add(laborEstimation.getTotalPrice());
        return total.setScale(2, BigDecimal.ROUND_CEILING);
    }

    public LaborEstimation getLaborEstimation() {
        return laborEstimation;
    }

    public void setLaborEstimation(LaborEstimation laborEstimation) {
        this.laborEstimation = laborEstimation;
    }

    public String getAddress() {
        return address;
    }

    public MaterialEstimation getMaterialEstimation() {
        return materialEstimation;
    }

    public void setMaterialEstimation(MaterialEstimation materialEstimation) {
        this.materialEstimation = materialEstimation;
    }

    public void setAddress(String address) {
        this.address = address;

    }
}
