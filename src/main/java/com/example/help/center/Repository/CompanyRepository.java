package com.example.help.center.Repository;
import com.example.help.center.entity.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyRepository {

    @Insert("""
        INSERT INTO companies (name, email, phone, address, logo_url, is_active)
        VALUES (#{name}, #{email}, #{phone}, #{address}, #{logoUrl}, #{isActive})
        RETURNING id
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Company company);

    @Select("SELECT * FROM companies WHERE id = #{id}")
    Company findById(Long id);

    @Select("SELECT * FROM companies")
    List<Company> findAll();

    @Update("""
        UPDATE companies SET name=#{name}, email=#{email}, phone=#{phone},
        address=#{address}, logo_url=#{logoUrl}, is_active=#{isActive}
        WHERE id = #{id}
    """)
    void update(Company company);

    @Delete("DELETE FROM companies WHERE id = #{id}")
    void delete(Long id);
}
