package com.example.help.center.cleanerServices.service;


import java.util.List;

import com.example.help.center.cleanerServices.entity.Service;

public interface CoreServices {
    void addService(Service service);
    Service getServiceById(Long id);
    List<Service> getAllServicesByCompany(Long companyId);
    void updateService(Service service);
    void deleteService(Long id);
}

