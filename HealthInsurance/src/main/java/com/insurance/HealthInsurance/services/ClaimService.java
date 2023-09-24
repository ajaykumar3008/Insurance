package com.insurance.HealthInsurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.HealthInsurance.contractors.InsuranceClaim;
import com.insurance.HealthInsurance.models.Claim;
import com.insurance.HealthInsurance.models.ClaimBills;
import com.insurance.HealthInsurance.models.DiseaseDetails;
import com.insurance.HealthInsurance.models.InsurancePackage;
import com.insurance.HealthInsurance.models.InsurancePackageCoveredDisease;


@Service
public class ClaimService {

	@Autowired
	InsuranceClaim insuranceClaim;
	
	
	public void addClaim(Claim claim) {
		insuranceClaim.addClaim(claim);
	}
	
	
	    public List<InsurancePackage> getAllInsurancePackages() {
	        return insuranceClaim.getAllInsurancePackages();
	    }
	    
	    public List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId) {
	        return insuranceClaim.getCoveredDiseasesByPackageId(packageId);
	    }

		
		public DiseaseDetails getDiseaseDetailsById(int discId) {
		
			return  insuranceClaim.getDetailsByDiseaseId(discId);
		}

		
		public List<InsurancePackage> getFilteredPackages(String status, int age) {
			return  insuranceClaim.getFiteredDiseases(status,age);
		}

		
		public List<InsurancePackage> getPackagesByStatus(String status) {
			
			return  insuranceClaim.getPackagesByStatus(status);
		}

		
		public List<InsurancePackage> getAllInsurancePackagesByAge(int age) {
			
			return  insuranceClaim.getAllInsurancePackagesByAge(age);
		}
		
		public List<ClaimBills> getRejectedLoans() {
			
			return insuranceClaim.getRejectedLoans();
		}

		public List<ClaimBills> getFilteredClaims(String status) {

			return (List<ClaimBills>)insuranceClaim.getFilteredClaims(status);
		}
		
	    public List<ClaimBills> getAllApplicants() {
	        return insuranceClaim.getAllApplicants();
	    }

	    
	    public List<ClaimBills> getAllClaims() {
	        return insuranceClaim.getAllClaims();
	    }
}
