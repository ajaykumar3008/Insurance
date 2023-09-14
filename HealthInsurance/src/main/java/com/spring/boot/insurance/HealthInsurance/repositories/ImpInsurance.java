package com.spring.boot.insurance.HealthInsurance.repositories;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.boot.insurance.HealthInsurance.contractors.InsuranceContractor;
import com.spring.boot.insurance.HealthInsurance.models.Customers;
import com.spring.boot.insurance.HealthInsurance.rowmappers.CustomerRowMapper;

@Repository
public class ImpInsurance implements InsuranceContractor {

	JdbcTemplate jdbc;

	@Autowired
	public ImpInsurance(DataSource ds) {
		this.jdbc = new JdbcTemplate(ds);

	}

	@Override
	public List<Customers> getAllCustomers() {

		return jdbc.query("select * from ins_customers", new CustomerRowMapper());

	}

}
