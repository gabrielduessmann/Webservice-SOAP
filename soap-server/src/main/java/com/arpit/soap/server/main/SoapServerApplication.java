package com.arpit.soap.server.main;

import javax.xml.ws.Endpoint;


import com.arpit.soap.server.model.ApplicationCredentials;
import com.arpit.soap.server.model.OperationSoap;
import com.arpit.soap.server.service.OperationSoapService;
import com.arpit.soap.server.service.impl.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arpit.soap.server.service.impl.HelloWorldServiceImpl;

@SpringBootApplication
public class SoapServerApplication implements CommandLineRunner {

	@Value("${service.port}")
	private String servicePort;

	@Override
	public void run(String... args) throws Exception {
		Endpoint.publish("http://0.0.0:" + servicePort
				+ "/service/hello-world", new HelloWorldServiceImpl());
	}

	public static void main(String[] args) {
		SpringApplication.run(SoapServerApplication.class, args);
	}
}
