package com.spring.boot.insurance.HealthInsurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.insurance.HealthInsurance.models.Customers;
import com.spring.boot.insurance.HealthInsurance.repositories.ImpInsurance;

@Service
public class InsuranceService {

	ImpInsurance impInsurance;

	@Autowired
	public InsuranceService(ImpInsurance impInsurance) {
		this.impInsurance = impInsurance;
	}

	public List<Customers> getAllCusomers() {

		return impInsurance.getAllCustomers();
	}
}
