package com.example.help.center.Repository;
import com.example.help.center.entity.SubscriptionPlan;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface SubscriptionPlanRepository {

    @Insert("""
        INSERT INTO subscription_plans (name, price, duration, max_cleaners, max_clients)
        VALUES (#{name}, #{price}, #{duration}, #{maxCleaners}, #{maxClients})
        RETURNING id
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(SubscriptionPlan plan);

    @Select("SELECT * FROM subscription_plans WHERE id=#{id}")
    SubscriptionPlan findById(Long id);

    @Select("SELECT * FROM subscription_plans ORDER BY price ASC")
    List<SubscriptionPlan> findAll();

    @Update("""
        UPDATE subscription_plans 
        SET name=#{name}, price=#{price}, duration=#{duration}, 
            max_cleaners=#{maxCleaners}, max_clients=#{maxClients}
        WHERE id=#{id}
    """)
    void update(SubscriptionPlan plan);

    @Delete("DELETE FROM subscription_plans WHERE id=#{id}")
    void delete(Long id);
}
