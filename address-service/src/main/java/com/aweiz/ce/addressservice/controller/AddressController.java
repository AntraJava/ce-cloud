package com.aweiz.ce.addressservice.controller;

import com.aweiz.ce.addressservice.service.AddressVerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AddressController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
    @Autowired
    AddressVerificationService addrService;

    @GetMapping("/address")
    public String verify(@RequestParam String addr) {
        LOGGER.debug("Entered veridy address with "+ addr);
        return addrService.verify(addr);
    }
}
