package com.example.Insurance.Management.System.Services;

import com.example.Insurance.Management.System.Model.Claim;

import java.util.List;
import java.util.Optional;

public interface ClaimService {

    List<Claim> getAllClaims();

    Claim getClaimById(Long id);

    Claim createClaim(Claim claim);

    Claim updateClaim(Long id, Claim claim);

    boolean deleteClaim(Long id);
}
