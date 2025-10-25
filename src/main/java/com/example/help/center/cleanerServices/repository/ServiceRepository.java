package com.example.help.center.cleanerServices.repository;

import org.apache.ibatis.annotations.*;

import com.example.help.center.cleanerServices.entity.Service;

import java.util.List;

@Mapper
public interface ServiceRepository {

    @Insert("""
        INSERT INTO services (name, description, price, company_id)
        VALUES (#{name}, #{description}, #{price}, #{companyId})
        RETURNING id
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Service service);

    @Select("SELECT * FROM services WHERE id=#{id}")
    Service findById(Long id);

    @Select("SELECT * FROM services WHERE company_id=#{companyId}")
    List<Service> findByCompanyId(Long companyId);

    @Update("""
        UPDATE services SET name=#{name}, description=#{description}, price=#{price}
        WHERE id=#{id}
    """)
    void update(Service service);

    @Delete("DELETE FROM services WHERE id=#{id}")
    void delete(Long id);
}
