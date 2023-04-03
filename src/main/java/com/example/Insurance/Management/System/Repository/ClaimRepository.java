package com.example.Insurance.Management.System.Repository;

import com.example.Insurance.Management.System.Model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim,Long> {
}
