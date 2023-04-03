package com.example.Insurance.Management.System.Services.impl;

import com.example.Insurance.Management.System.Model.InsurancePolicy;
import com.example.Insurance.Management.System.Repository.InsurancePolicyRepository;
import com.example.Insurance.Management.System.Services.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;



    @Override
    public List<InsurancePolicy> getAllInsurancePolicies() {

        return insurancePolicyRepository.findAll();
    }

    @Override
    public Optional<InsurancePolicy> getInsurancePolicyById(Long id) {

        return insurancePolicyRepository.findById(id);
    }

    @Override
    public InsurancePolicy createInsurancePolicy(InsurancePolicy policy) {
        return insurancePolicyRepository.save(policy);
    }


    @Override
    public InsurancePolicy updateInsurancePolicy(InsurancePolicy policy) {
        return insurancePolicyRepository.save(policy);
    }

    @Override
    public void deleteInsurancePolicy(Long id) {
        insurancePolicyRepository.deleteById(id);
    }
    


}
