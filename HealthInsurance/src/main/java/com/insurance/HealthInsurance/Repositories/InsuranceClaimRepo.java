package com.insurance.HealthInsurance.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.insurance.HealthInsurance.contractors.InsuranceClaim;
import com.insurance.HealthInsurance.models.Claim;

@Repository
public class InsuranceClaimRepo implements InsuranceClaim {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public void addClaim(Claim claim) {
		
		String query="insert into Claims(patient_id,patient_name, date_of_birth, gender, contact_number, address, joined_date, disease, diagnosis, treatment, room_charges, medicine_bill, document_path) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] values= {claim.getPatientId(),claim.getPatientName(),claim.getDateOfBirth(),claim.getGender(),claim.getContactNumber(),claim.getAddress(),claim.getJoinedDate(),claim.getDisease(),claim.getDiagnosis(),claim.getTreatment(),claim.getRoomCharges(),claim.getMedicineBill(),claim.getDocumentPath()};
		
		jdbc.update(query, values);
	}
	
	
	
}
