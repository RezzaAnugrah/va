package com.mirae.payment.va;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mirae.payment.va.entity.Customer;
import com.mirae.payment.va.entity.Promo;
import com.mirae.payment.va.service.CustomerService;
import com.mirae.payment.va.service.PromoService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class VaApplication {

	@Autowired
	CustomerService customerService;
	@Autowired
	PromoService promoService;
	
	public static void main(String[] args) {
		SpringApplication.run(VaApplication.class, args);
	}

	@PostConstruct
	void setCustomer(){
		Customer customer1 = new Customer("CSM01","Jhon","Jhon@gmail.com","0812");
		Customer customer2 = new Customer("CSM02","Rezza","Rezza@gmail.com","0813");
		customerService.addCustomer(customer1);
		customerService.addCustomer(customer2);
	}

	@PostConstruct
	void setPromo(){
		Promo promo1 = new Promo("PRM01","Promo Kartini", 10000);
		Promo promo2 = new Promo("PRM02","Promo Mei", 25000);
		promoService.addPromo(promo1);
		promoService.addPromo(promo2);
	}
}
