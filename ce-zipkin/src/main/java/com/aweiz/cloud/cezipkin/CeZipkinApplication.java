package com.aweiz.cloud.cezipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class CeZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeZipkinApplication.class, args);
	}
}
