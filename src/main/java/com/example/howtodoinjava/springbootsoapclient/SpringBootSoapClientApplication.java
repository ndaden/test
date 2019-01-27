package com.example.howtodoinjava.springbootsoapclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.howtodoinjava.schemas.school.CapitalCityRequest;
import com.example.howtodoinjava.schemas.school.CapitalCityResponse;

@SpringBootApplication
@SpringBootConfiguration
public class SpringBootSoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			try {
				if (args.length > 0) {
				}
				CapitalCityRequest request = new CapitalCityRequest();
				request.setsCountryISOCode("FR");
				CapitalCityResponse response = (CapitalCityResponse) soapConnector.callWebService(
						"http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?wsdl", request);
				System.out.println("Got Response As below ========= : ");
				System.out.println("Name : " + response.getCapitalCityResult());
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
}