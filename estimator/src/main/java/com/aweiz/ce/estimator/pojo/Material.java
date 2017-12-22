package com.aweiz.ce.estimator.pojo;

import java.math.BigDecimal;

public class Material {
    private String name;
    private BigDecimal price;
    private Integer quatity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuatity() {
        return quatity;
    }

    public void setQuatity(Integer quatity) {
        this.quatity = quatity;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quatity=" + quatity +
                '}';
    }
}
