package com.example.help.center.Service.Impl;


import com.example.help.center.entity.Service;

import com.example.help.center.Repository.ServiceRepository;
import com.example.help.center.Service.CoreServices;

import java.util.List;

@org.springframework.stereotype.Service
public class CoreServiceImpl implements CoreServices {

    private final ServiceRepository mapper;

    public CoreServiceImpl(ServiceRepository mapper) {
        this.mapper = mapper;
    }

    @Override
    public void addService(Service service) {
        mapper.insert(service);
    }

    @Override
    public Service getServiceById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<Service> getAllServicesByCompany(Long companyId) {
        return mapper.findByCompanyId(companyId);
    }

    @Override
    public void updateService(Service service) {
        mapper.update(service);
    }

    @Override
    public void deleteService(Long id) {
        mapper.delete(id);
    }
}
