package com.example.help.center.Repository;

import com.example.help.center.entity.Cleaner;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CleanerRepository {

    @Insert("""
        INSERT INTO cleaners (f_name, l_name, phone, national_id, gender, address, company_id, is_available)
        VALUES (#{fullName}, #{phone}, #{nationalId}, #{gender}, #{address}, #{companyId}, #{isAvailable})
        RETURNING id
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Cleaner cleaner);

    @Select("SELECT * FROM cleaners WHERE id=#{id}")
    Cleaner findById(Long id);

    @Select("SELECT * FROM cleaners WHERE company_id=#{companyId}")
    List<Cleaner> findByCompanyId(Long companyId);

    @Update("""
        UPDATE cleaners SET f_name=#{f_name}, l_name=#{l_name}, phone=#{phone}, address=#{address}, 
        is_available=#{isAvailable} WHERE id=#{id}
    """)
    void update(Cleaner cleaner);

    @Delete("DELETE FROM cleaners WHERE id=#{id}")
    void delete(Long id);
}
