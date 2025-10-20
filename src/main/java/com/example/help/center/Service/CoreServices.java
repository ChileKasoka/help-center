package com.example.help.center.Service;

import com.example.help.center.entity.Service;
import java.util.List;

public interface CoreServices {
    void addService(Service service);
    Service getServiceById(Long id);
    List<Service> getAllServicesByCompany(Long companyId);
    void updateService(Service service);
    void deleteService(Long id);
}

