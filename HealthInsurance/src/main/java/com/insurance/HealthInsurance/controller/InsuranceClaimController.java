package com.insurance.HealthInsurance.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import com.insurance.HealthInsurance.contractors.InsuranceClaim;
import com.insurance.HealthInsurance.models.Claim;
import com.insurance.HealthInsurance.models.ClaimBills;
import com.insurance.HealthInsurance.models.DiseaseDetails;
import com.insurance.HealthInsurance.models.InsurancePackage;
import com.insurance.HealthInsurance.models.InsurancePackageCoveredDisease;
import com.insurance.HealthInsurance.services.ClaimService;



@Controller
public class InsuranceClaimController {
	
	@Autowired
	ClaimService claimService;

	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String addCalim() {
		
			return "dashboard";
	}
	
	@RequestMapping(value="/dash",method=RequestMethod.GET)
	public String dashboard() {
			return "HospitalDashboard";
	}
	
	@RequestMapping(value="/apply-claim",method=RequestMethod.POST)
	public String claimData(@RequestParam("file") MultipartFile file,Claim claim, Model model) {
		

	    Path path = Paths.get("C:\\Users\\Ajay kumar\\OneDrive\\Desktop\\", file.getOriginalFilename());

	    if (!Files.exists(path)) {
	        model.addAttribute("message", "File not found.");
	        return "claim";
	    }

	    try {
	        byte[] bytes = file.getBytes();
	        Files.write(path, bytes);

	        String filePath = path.toString();
	        claim.setDocumentPath(filePath);
	       
	    } catch (IOException e) {
	        e.printStackTrace();
	        
	    }

	    claimService.addClaim(claim);
	    
	    return "success";
	}
	
	

	@GetMapping("/list")
	public String getAllInsurancePackages(Model model) {
		List<InsurancePackage> insurancePackages = claimService.getAllInsurancePackages();

		model.addAttribute("insurancePackages", insurancePackages);

		return "packages"; 
	}

	@GetMapping("/view-insurance/{inspId}")
	public String viewInsurance(@PathVariable int inspId, Model model) {
		
		List<InsurancePackageCoveredDisease> coveredDiseases = claimService.getCoveredDiseasesByPackageId(inspId);

		model.addAttribute("coveredDiseases", coveredDiseases);

		return "insurance-package-view";
	}

	@GetMapping("/diseasedetails/{discId}")
	public String viewDiseseDetails(@PathVariable int discId, Model model) {
		DiseaseDetails dd = claimService.getDiseaseDetailsById(discId);
		model.addAttribute("diseasedetails", dd);
		System.out.println("age1");
		return "diseasedetails";

	}

	@RequestMapping(value = "/start")
	public String packages() {
		return "redirect:/list";

	}

	@GetMapping("/filteredpackages")
	public String getFilteredPackages(@RequestParam("status") String status, @RequestParam("age") String age,
			Model model) {
		System.out.println(status);
		if ("ALL".equals(status) && age.equals("")) {
			System.out.println("if");
			List<InsurancePackage> insurancePackages = claimService.getAllInsurancePackages();

			System.out.println(insurancePackages);
			model.addAttribute("insurancePackages", insurancePackages);

			return "packages";
		}
		else if ("ALL".equals(status) && !age.equals("")) {
			System.out.println("if");
			List<InsurancePackage> insurancePackages = claimService.getAllInsurancePackagesByAge(Integer.parseInt(age));

			System.out.println(insurancePackages);
			model.addAttribute("insurancePackages", insurancePackages);

			return "packages";
		}
		else {

			if (age.equals("")) {
				List<InsurancePackage> insurancePackages = claimService.getPackagesByStatus(status);
				model.addAttribute("insurancePackages", insurancePackages);
				return "packages";
			} else {
				List<InsurancePackage> packages = claimService.getFilteredPackages(status,
						Integer.parseInt(age));
				model.addAttribute("insurancePackages", packages);
				System.out.println(packages);
				System.out.println(age);

				return "packages";

			}
		}

	}
	

	@RequestMapping(value="/claimdash",method=RequestMethod.GET)
	public  String ClaimApplicants() {
		
		return "hell";
	}
	@RequestMapping(value="/applicants",method=RequestMethod.GET)
	public  String getDashBoard(Model model) {
		List<ClaimBills> claimbills=claimService.getAllApplicants();
		model.addAttribute("claimbills",claimbills);
		return "hell";
		
	}
	@RequestMapping(value="/claims",method=RequestMethod.GET)
	public String getDetails(Model model) {
		
		List<ClaimBills> claimbills=claimService.getAllClaims();
		model.addAttribute("claimbills",claimbills);
		return "hell";
		
	}
	
	@RequestMapping(value="/rejected",method=RequestMethod.GET)
	public String getAllRejectedLoans(Model model) {
		List<ClaimBills> claimbills=claimService.getRejectedLoans();
		model.addAttribute("claimbills",claimbills);
		
		return "hell";
	}
	
    @GetMapping(value = "/getFilteredClaims")
    public String getFilteredClaims(Model model,@RequestParam("status") String status) {
   
        ArrayList<ClaimBills> claimbills = (ArrayList<ClaimBills>) claimService.getFilteredClaims(status);

        model.addAttribute("claimbills",claimbills);
        return "hell";
    }
	

}
