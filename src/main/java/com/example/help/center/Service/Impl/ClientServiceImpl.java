package com.example.help.center.Service.Impl;


import org.springframework.stereotype.Service;

import com.example.help.center.Repository.ClientRepository;
import com.example.help.center.Service.ClientService;
import com.example.help.center.entity.Client;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository mapper;

    public ClientServiceImpl(ClientRepository mapper) {
        this.mapper = mapper;
    }

    @Override
    public void addClient(Client client) {
        mapper.insert(client);
    }

    @Override
    public Client getClientById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<Client> getAllClientsByCompany(Long companyId) {
        return mapper.findByCompanyId(companyId);
    }

    @Override
    public void updateClient(Client client) {
        mapper.update(client);
    }

    @Override
    public void deleteClient(Long id) {
        mapper.delete(id);
    }
}
