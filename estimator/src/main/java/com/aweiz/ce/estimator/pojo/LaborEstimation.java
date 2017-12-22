package com.aweiz.ce.estimator.pojo;

import java.math.BigDecimal;
import java.util.List;

public class LaborEstimation {
    private BigDecimal totalPrice;
    private List<Labor> breakdowns;

    public BigDecimal getTotalPrice() {
        return totalPrice.setScale(2, BigDecimal.ROUND_CEILING);
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Labor> getBreakdowns() {
        return breakdowns;
    }

    public void setBreakdowns(List<Labor> breakdowns) {
        this.breakdowns = breakdowns;
    }
}
