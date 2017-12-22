package com.aweiz.ce.estimator.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceLocalImpl implements AddressService {

    @Override
    public String verifyAddress(String addr) {
        return addr.toUpperCase();
    }

}
