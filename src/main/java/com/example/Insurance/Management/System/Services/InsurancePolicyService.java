package com.example.Insurance.Management.System.Services;


import com.example.Insurance.Management.System.Model.InsurancePolicy;

import java.util.List;
import java.util.Optional;

public interface InsurancePolicyService {



      public List<InsurancePolicy> getAllInsurancePolicies();

      public Optional<InsurancePolicy> getInsurancePolicyById(Long id);

      public InsurancePolicy createInsurancePolicy(InsurancePolicy policy);

      public  InsurancePolicy updateInsurancePolicy(InsurancePolicy policy);

       public void deleteInsurancePolicy(Long id);


}
