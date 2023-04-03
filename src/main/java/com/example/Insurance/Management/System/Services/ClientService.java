package com.example.Insurance.Management.System.Services;

import com.example.Insurance.Management.System.Model.Client;

import java.util.List;

public interface ClientService {

    public List<Client> getAllClients();

   public Client getClientById(Long id);

    public Client createClient(Client client);

    public Client updateClient(Long id, Client client);

     public boolean deleteClient(Long id);
}
