package com.example.help.center.Service;

import com.example.help.center.entity.Client;
import java.util.List;

public interface ClientService {
    void addClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClientsByCompany(Long companyId);
    void updateClient(Client client);
    void deleteClient(Long id);
}

