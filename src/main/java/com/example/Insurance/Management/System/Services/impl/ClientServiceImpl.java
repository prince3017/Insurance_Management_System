package com.example.Insurance.Management.System.Services.impl;


import com.example.Insurance.Management.System.Model.Client;
import com.example.Insurance.Management.System.Repository.ClientRepository;
import com.example.Insurance.Management.System.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    @Override
    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client client){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setName(client.getName());
            existingClient.setDateOfBirth(client.getDateOfBirth());
            existingClient.setAddress(client.getAddress());
            existingClient.setContactInformation(client.getContactInformation());
            return clientRepository.save(existingClient);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteClient(Long id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            clientRepository.delete(optionalClient.get());
            return true;
        } else {
            return false;
        }
    }

}

