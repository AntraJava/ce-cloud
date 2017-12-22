package com.aweiz.ce.laborservice.pojo;

import java.math.BigDecimal;
import java.util.List;

public class LaborEstimation {
    private BigDecimal totalPrice;
    private List<Labor> breakdowns;

    public BigDecimal getTotalPrice() {
        return totalPrice;
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
