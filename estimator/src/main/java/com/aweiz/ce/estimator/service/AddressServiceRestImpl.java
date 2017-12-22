package com.aweiz.ce.estimator.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Primary
public class AddressServiceRestImpl implements AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressServiceRestImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AddressServiceLocalImpl localService;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    public String verifyAddress(String addr) {
        ResponseEntity<?> res = restTemplate.exchange("http://addressservice/address?addr={addr}",  HttpMethod.GET, null, String.class, addr);
        logger.info(res.toString());
        return (String)res.getBody();
    }

    public String fallbackMethod(String addr, Throwable e) {
        logger.error("From REST - Something wrong in verifyAddress, give local impl instead, error is", e);
        return localService.verifyAddress(addr);
    }
}
