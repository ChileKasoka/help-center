package com.example.help.center.Repository;

import com.example.help.center.entity.Client;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ClientRepository {

    @Insert("""
        INSERT INTO clients (full_name, phone, email, address, company_id)
        VALUES (#{fullName}, #{phone}, #{email}, #{address}, #{companyId})
        RETURNING id
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Client client);

    @Select("SELECT * FROM clients WHERE id=#{id}")
    Client findById(Long id);

    @Select("SELECT * FROM clients WHERE company_id=#{companyId}")
    List<Client> findByCompanyId(Long companyId);

    @Update("""
        UPDATE clients SET full_name=#{fullName}, phone=#{phone}, 
        email=#{email}, address=#{address} WHERE id=#{id}
    """)
    void update(Client client);

    @Delete("DELETE FROM clients WHERE id=#{id}")
    void delete(Long id);
}
