package com.insurance.HealthInsurance.contractors;

import java.util.List;

import com.insurance.HealthInsurance.models.Claim;
import com.insurance.HealthInsurance.models.ClaimBills;
import com.insurance.HealthInsurance.models.DiseaseDetails;
import com.insurance.HealthInsurance.models.InsurancePackage;
import com.insurance.HealthInsurance.models.InsurancePackageCoveredDisease;
public interface InsuranceClaim {

	void addClaim(Claim claim);
	List<InsurancePackage> getAllInsurancePackages();
	List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId);
	DiseaseDetails getDetailsByDiseaseId(int discId);
	List<InsurancePackage> getFiteredDiseases(String status, int age);
	List<InsurancePackage> getPackagesByStatus(String status);
	List<InsurancePackage> getAllInsurancePackagesByAge(int age);

    List<ClaimBills> getAllApplicants();
    
    List<ClaimBills> getAllClaims();
 
	List<ClaimBills> getRejectedLoans();

	List<ClaimBills> getFilteredClaims(String status);
}
