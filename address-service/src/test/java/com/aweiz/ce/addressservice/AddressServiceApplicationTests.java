package com.aweiz.ce.addressservice;

import com.aweiz.ce.addressservice.service.AddressVerificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceApplicationTests {
	@Autowired
	AddressVerificationService service;
	@Test
	public void contextLoads() {
		System.out.println(service.verify("22615 norwalk"));
	}

}
