package com.example.help.center.client.service;


import java.util.List;

import com.example.help.center.client.entity.Client;

public interface ClientService {
    void addClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClientsByCompany(Long companyId);
    void updateClient(Client client);
    void deleteClient(Long id);
}

