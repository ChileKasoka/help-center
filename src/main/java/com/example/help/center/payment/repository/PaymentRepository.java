package com.example.help.center.payment.repository;


import org.apache.ibatis.annotations.*;

import com.example.help.center.payment.entity.Payment;

import java.util.List;

@Mapper
public interface PaymentRepository {

    @Insert("""
        INSERT INTO payments (amount, payment_date, reference, payment_method, confirmed, 
                              payment_type, company_id, booking_id)
        VALUES (#{amount}, #{paymentDate}, #{reference}, #{paymentMethod}, #{confirmed}, 
                #{paymentType}, #{companyId}, #{bookingId})
        RETURNING id
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Payment payment);

    @Select("SELECT * FROM payments WHERE id=#{id}")
    Payment findById(Long id);

    @Select("SELECT * FROM payments WHERE company_id=#{companyId}")
    List<Payment> findByCompanyId(Long companyId);

    @Update("""
        UPDATE payments SET confirmed=#{confirmed}, payment_method=#{paymentMethod}
        WHERE id=#{id}
    """)
    void update(Payment payment);

    @Delete("DELETE FROM payments WHERE id=#{id}")
    void delete(Long id);
}
