package com.example.Insurance.Management.System.Services.impl;

import com.example.Insurance.Management.System.Model.Claim;
import com.example.Insurance.Management.System.Repository.ClaimRepository;
import com.example.Insurance.Management.System.Services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl  implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public Claim getClaimById(Long id) {
        Optional<Claim> claim = claimRepository.findById(id);
        return claim.orElse(null);
    }

    @Override
    public Claim createClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    @Override
    public Claim updateClaim(Long id, Claim claim) {
        Optional<Claim> existingClaim = claimRepository.findById(id);
        if (!existingClaim.isPresent()) {
            return null;
        }
        claim.setId(id);
        return claimRepository.save(claim);
    }

    @Override
    public boolean deleteClaim(Long id) {
        Optional<Claim> existingClaim = claimRepository.findById(id);
        if (!existingClaim.isPresent()) {
            return false;
        }
        claimRepository.deleteById(id);
        return true;
    }
}
