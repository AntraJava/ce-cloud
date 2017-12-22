package com.aweiz.ce.estimator.pojo;

import java.util.List;

public class EstimationParam {
    private String address;
    private Double size;
    private String type;
    private List<Material> materials;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return "EstimationParam{" +
                "address='" + address + '\'' +
                ", size=" + size +
                "sf, type='" + type + '\'' +
                ", materials=" + materials +
                '}';
    }
}
