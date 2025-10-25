package com.example.help.center.cleanerServices.service.impl;

import java.util.List;

import com.example.help.center.cleanerServices.entity.Service;
import com.example.help.center.cleanerServices.repository.ServiceRepository;
import com.example.help.center.cleanerServices.service.CoreServices;

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
