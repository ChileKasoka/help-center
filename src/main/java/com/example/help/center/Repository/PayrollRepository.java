package com.example.help.center.Repository;

import com.example.help.center.entity.Payroll;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PayrollRepository {

    @Insert("""
        INSERT INTO payrolls (start_period, end_period, total_earnings, cleaner_id, company_id)
        VALUES (#{startPeriod}, #{endPeriod}, #{totalEarnings}, #{cleanerId}, #{companyId})
        RETURNING id
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Payroll payroll);

    @Select("SELECT * FROM payrolls WHERE id=#{id}")
    Payroll findById(Long id);

    @Select("SELECT * FROM payrolls WHERE company_id=#{companyId}")
    List<Payroll> findByCompanyId(Long companyId);

    @Update("""
        UPDATE payrolls SET total_earnings=#{totalEarnings}, end_period=#{endPeriod}
        WHERE id=#{id}
    """)
    void update(Payroll payroll);

    @Delete("DELETE FROM payrolls WHERE id=#{id}")
    void delete(Long id);
}
