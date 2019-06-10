package com.bank.ats.starter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;



@SpringBootApplication(scanBasePackages = "com.bank")
@EnableAutoConfiguration
@EntityScan("com.bank.ats.entity")
@ImportResource(locations = {"classpath*:/spring/account-transaction-service.xml"})
@EnableConfigurationProperties
public class AccountsAndTransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsAndTransactionServiceApplication.class, args);
	}

}
