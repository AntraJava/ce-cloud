package com.aweiz.ce.laborservice.pojo;

import java.util.List;

public class LaborEstimationParam {
    private String address;
    private Double size;
    private String type;

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

    @Override
    public String toString() {
        return "EstimationParam{" +
                "address='" + address + '\'' +
                ", size=" + size +
                "sf, type='" + type + '\'' +
                '}';
    }
}
