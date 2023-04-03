package com.example.Insurance.Management.System.Controller;


import com.example.Insurance.Management.System.Model.InsurancePolicy;
import com.example.Insurance.Management.System.Services.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;

    @GetMapping
    public List<InsurancePolicy> getAllInsurancePolicies() {
        return insurancePolicyService.getAllInsurancePolicies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable Long id) {
        Optional<InsurancePolicy> policy = insurancePolicyService.getInsurancePolicyById(id);
        if (policy.isPresent()) {
            return ResponseEntity.ok(policy.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<InsurancePolicy> createInsurancePolicy(@RequestBody InsurancePolicy policy) {
        InsurancePolicy createdPolicy = insurancePolicyService.createInsurancePolicy(policy);
        return ResponseEntity.created(URI.create("/api/policies/" + createdPolicy.getId())).body(createdPolicy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updateInsurancePolicy(@PathVariable Long id, @RequestBody InsurancePolicy policy) {
        Optional<InsurancePolicy> existingPolicy = insurancePolicyService.getInsurancePolicyById(id);
        if (existingPolicy.isPresent()) {
            policy.setId(id);
            InsurancePolicy updatedPolicy = insurancePolicyService.updateInsurancePolicy(policy);
            return ResponseEntity.ok(updatedPolicy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurancePolicy(@PathVariable Long id) {
        Optional<InsurancePolicy> existingPolicy = insurancePolicyService.getInsurancePolicyById(id);
        if (existingPolicy.isPresent()) {
            insurancePolicyService.deleteInsurancePolicy(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
