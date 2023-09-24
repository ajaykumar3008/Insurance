package com.insurance.HealthInsurance.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import com.insurance.HealthInsurance.contractors.InsuranceClaim;
import com.insurance.HealthInsurance.models.Claim;



@Controller
public class InsuranceClaimController {
	
	@Autowired
	InsuranceClaim insuranceClaim;

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

	    insuranceClaim.addClaim(claim);
	    
	    return "success";
	}

}
