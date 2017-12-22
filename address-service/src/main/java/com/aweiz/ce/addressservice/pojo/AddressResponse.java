package com.aweiz.ce.addressservice.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressResponse {

    @JsonProperty("standard")
    private StandardAddress standard;

    public String getNormalizedAddr() {
        return standard.getStreet();
    }

    public StandardAddress getStandard() {
        return standard;
    }

    public void setStandard(StandardAddress standard) {
        this.standard = standard;
    }
}
