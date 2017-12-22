package com.aweiz.ce.laborservice.pojo;

public class Labor {
    private String laborType;
    private Double price;
    private Integer quatity;

    public String getLaborType() {
        return laborType;
    }

    public void setLaborType(String laborType) {
        this.laborType = laborType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
                "laborType='" + laborType + '\'' +
                ", price=" + price +
                ", quatity=" + quatity +
                '}';
    }
}
