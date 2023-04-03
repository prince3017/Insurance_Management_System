package com.example.Insurance.Management.System.Repository;

import com.example.Insurance.Management.System.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
