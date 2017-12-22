package com.aweiz.ce.addressservice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StandardAddress {
    @JsonProperty("addresst")
    private String street;
    @JsonProperty("city")
    private String city;
    @JsonProperty("prov")
    private String state;
    @JsonProperty("countryname")
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
