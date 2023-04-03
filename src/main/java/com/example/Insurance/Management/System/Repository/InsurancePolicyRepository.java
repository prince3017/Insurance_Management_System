package com.example.Insurance.Management.System.Repository;

import com.example.Insurance.Management.System.Model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {
}
