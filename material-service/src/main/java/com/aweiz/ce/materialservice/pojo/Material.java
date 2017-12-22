package com.aweiz.ce.materialservice.pojo;

public class Material {
    private String name;
    private Double price;
    private Integer quatity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", price=" + price +
                ", quatity=" + quatity +
                '}';
    }
}
