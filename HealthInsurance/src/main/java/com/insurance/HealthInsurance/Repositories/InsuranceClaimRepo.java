package com.insurance.HealthInsurance.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.HealthInsurance.contractors.InsuranceClaim;
import com.insurance.HealthInsurance.models.Claim;
import com.insurance.HealthInsurance.models.ClaimBills;
import com.insurance.HealthInsurance.models.DiseaseDetails;
import com.insurance.HealthInsurance.models.InsurancePackage;
import com.insurance.HealthInsurance.models.InsurancePackageCoveredDisease;
import com.insurance.HealthInsurance.rowmappers.*;

@Component
public class InsuranceClaimRepo implements InsuranceClaim {

	
	private static final String GET_INSURANCE_PACKAGES = "SELECT * FROM InsurancePackages";
	private static final String GET_COVERED_DISEASES_BY_PACKAGE_ID = "SELECT * FROM InsurancePackageCoveredDiseases WHERE insp_id = ?";
	private static final String GET_DISEASE_DETAILS_BY_DISEASE_ID = "select * from DiseaseDetails where disc_id=?";
	private static final String GET_FILTERED_PACKAGES="select * FROM InsurancePackages where insp_status=? and ? BETWEEN insp_agelimit_start AND insp_agelimit_end;";
	private static final String GET_PACKAGES_BY_STATUS="select * FROM InsurancePackages where insp_status=?";
	private static final String GET_FILTERED_PACKAGES_BY_AGE = "select * FROM InsurancePackages where ? BETWEEN insp_agelimit_start AND insp_agelimit_end;";

    // Define SQL queries as constants
    private static final String SELECT_ALL_CLAIM_BILLS = "SELECT * FROM claim_bills";
    private static final String SELECT_FULL_CLAIM_BILLS = "SELECT * FROM claim_bills WHERE clbl_status = 'FULL'";
    private static final String SELECT_ALL_REJECTED="SELECT * FROM claim_bills where clbl_status='RJCT' or clbl_status='PART'"; 
    private static final String SELECT_ALL_Filtered="select * from claim_bills where clbl_status=?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addClaim(Claim claim) {
		
		String query="insert into Claims(patient_id,patient_name, date_of_birth, gender, contact_number, address, joined_date, disease, diagnosis, treatment, room_charges, medicine_bill, document_path) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] values= {claim.getPatientId(),claim.getPatientName(),claim.getDateOfBirth(),claim.getGender(),claim.getContactNumber(),claim.getAddress(),claim.getJoinedDate(),claim.getDisease(),claim.getDiagnosis(),claim.getTreatment(),claim.getRoomCharges(),claim.getMedicineBill(),claim.getDocumentPath()};
		
		jdbcTemplate.update(query, values);
	}
	
	@Override
	public List<InsurancePackage> getAllInsurancePackages() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_INSURANCE_PACKAGES, new InsurancePackageRowMapper());
	}

	public List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId) {
		return jdbcTemplate.query(GET_COVERED_DISEASES_BY_PACKAGE_ID, new Object[] { packageId },
				new InsurancePackageCoveredDiseaseRowMapper());
	}

	@Override
	public DiseaseDetails getDetailsByDiseaseId(int discId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GET_DISEASE_DETAILS_BY_DISEASE_ID, new Object[] { discId },
				new DiseseDetailsRowMapper());
	}

	@Override
	public List<InsurancePackage> getFiteredDiseases(String status, int age) {
		// TODO Auto-generated method stub
		System.out.println("dao"+status+age);
		//System.out.println(jdbcTemplate.query("select * FROM InsurancePackages", values, new InsurancePackageRowMapper()));
		return jdbcTemplate.query(GET_FILTERED_PACKAGES,new Object[] {status,age}, new InsurancePackageRowMapper());
	}

	@Override
	public List<InsurancePackage> getPackagesByStatus(String status) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_PACKAGES_BY_STATUS, new Object[] {status} ,new InsurancePackageRowMapper());
	}

	@Override
	public List<InsurancePackage> getAllInsurancePackagesByAge(int age) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_FILTERED_PACKAGES_BY_AGE,new Object[] {age}, new InsurancePackageRowMapper());
	}
	

	@Override
	public List<ClaimBills> getRejectedLoans() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_ALL_REJECTED,new ClaimBillsRowMappers());
		
	}

	@Override
	public List getFilteredClaims(String status) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_ALL_Filtered, new Object[] {status},new ClaimBillsRowMappers());
	}
	
	@Override
    public List<ClaimBills> getAllApplicants() {
        return jdbcTemplate.query(SELECT_ALL_CLAIM_BILLS, new ClaimBillsRowMappers());

    }
    

    @Override
    public List<ClaimBills> getAllClaims() {
        return jdbcTemplate.query(SELECT_FULL_CLAIM_BILLS, new ClaimBillsRowMappers());
    }
	
}
