package com.spring.boot.insurance.HealthInsurance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.insurance.HealthInsurance.models.Customers;
import com.spring.boot.insurance.HealthInsurance.services.InsuranceService;

@RestController
public class InsuranceController {

	InsuranceService insService;

	@Autowired
	public InsuranceController(InsuranceService insService) {
		this.insService = insService;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customers> getAllCustomer() {

		System.out.println("ajay");
		return insService.getAllCusomers();
	}
}
