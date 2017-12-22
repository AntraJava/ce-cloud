package com.aweiz.ce.materialservice.pojo;

import java.math.BigDecimal;
import java.util.List;

public class MaterialEstimation {
    private BigDecimal totalPrice;
    private List<Material> breakdowns;

    public BigDecimal getTotalPrice() {
        return totalPrice;
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
