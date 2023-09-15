package com.spring.boot.insurance.HealthInsurance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
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

		return insService.getAllCusomers();
	}

	@RequestMapping(value = "/customerentry", method = RequestMethod.POST)
	public ResponseEntity<Object> customerEntry(@RequestBody Customers cust,
			@DateTimeFormat(pattern = "dd-MM-yyyy") BindingResult bindingResult) {

		insService.addNewCustomer(cust);
		return new ResponseEntity("customer added successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/customerupdate", method = RequestMethod.PUT)
	public ResponseEntity<Object> customerUpdate(Customers cust) {

		insService.updateCustomer(cust);
		return new ResponseEntity("customer updated successfully", HttpStatus.OK);
	}
}
