package com.spring.boot.insurance.HealthInsurance.contractors;

import java.util.List;

import com.spring.boot.insurance.HealthInsurance.models.Customers;

public interface InsuranceContractor {

	List<Customers> getAllCustomers();

	void addCustomer(Customers cust);

	void updateCustomer(Customers cust);

}
