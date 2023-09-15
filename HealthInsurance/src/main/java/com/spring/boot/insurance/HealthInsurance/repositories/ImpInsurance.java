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

	@Override
	public void addCustomer(Customers cust) {

		String query = "insert into ins_customers values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { cust.getCust_id(), cust.getCust_firstname(), cust.getCust_lastname(), cust.getCust_dob(),
				cust.getCust_address(), cust.getCust_gender(), cust.getCust_cdate(), cust.getCust_aadhar(),
				cust.getCust_status(), cust.getCust_ludate(), cust.getCust_luuser() };

		jdbc.update(query, params);

	}

	@Override
	public void updateCustomer(Customers cust) {

		String query = "update ins_customers set cust_fname=?,cust_lname=?,cust_dob=?,cust_address=?,cust_gender=?,cust_cdate=?,cust_aadhar=?,cust_status=?,cust_luudate=?,cust_luuser=? where cust_id=?";
		Object[] params = { cust.getCust_firstname(), cust.getCust_lastname(), cust.getCust_dob(),
				cust.getCust_address(), cust.getCust_gender(), cust.getCust_cdate(), cust.getCust_aadhar(),
				cust.getCust_status(), cust.getCust_ludate(), cust.getCust_luuser(), cust.getCust_id() };

		jdbc.update(query, params);

	}

}
