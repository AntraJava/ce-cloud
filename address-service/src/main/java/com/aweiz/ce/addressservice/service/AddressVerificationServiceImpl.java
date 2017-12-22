package com.aweiz.ce.addressservice.service;

import com.aweiz.ce.addressservice.pojo.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class AddressVerificationServiceImpl implements AddressVerificationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressVerificationServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String verify(String addr) {
        LOGGER.debug("Entered AddressVerificationServiceImpl");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "curl/7.37.0");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<AddressResponse> responseEntity = restTemplate.exchange("https://geocode.xyz/?locate={location}&json=1", HttpMethod.GET, entity, AddressResponse.class, addr);
        if(responseEntity.getBody() != null) {
            LOGGER.debug("Got the verified address: "+ responseEntity.getBody().getNormalizedAddr());
            return responseEntity.getBody().getNormalizedAddr();
        }else{
            LOGGER.debug("Cannot Verify the address");

            return "Cannot verfity the address";
        }
    }

}
