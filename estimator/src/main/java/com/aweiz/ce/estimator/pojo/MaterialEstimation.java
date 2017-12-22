package com.aweiz.ce.estimator.pojo;

import java.math.BigDecimal;
import java.util.List;

public class MaterialEstimation {
    private BigDecimal totalPrice;
    private List<Material> breakdowns;

    public BigDecimal getTotalPrice() {
        return totalPrice.setScale(2, BigDecimal.ROUND_CEILING);
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Material> getBreakdowns() {
        return breakdowns;
    }

    public void setBreakdowns(List<Material> breakdowns) {
        this.breakdowns = breakdowns;
    }
}
