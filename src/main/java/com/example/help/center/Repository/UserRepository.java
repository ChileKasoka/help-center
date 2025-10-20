package com.example.help.center.Repository;

import com.example.help.center.entity.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserRepository {

    @Insert("INSERT INTO users(username, password, user_type) VALUES(#{username}, #{password}, #{userType})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Select("SELECT * FROM users WHERE id=#{id}")
    User findById(Long id);

    @Select("SELECT * FROM users WHERE username=#{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Select("SELECT * FROM users WHERE company_id=#{companyId}")
    List<User> findByCompanyId(Long companyId);

    @Select("SELECT * FROM users WHERE email=#{email}")
    User findByEmail(String email);

    @Update("UPDATE users SET username=#{username}, password=#{password}, user_type=#{userType} WHERE id=#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    void delete(Long id);
}
