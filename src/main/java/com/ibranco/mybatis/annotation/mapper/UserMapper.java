package com.ibranco.mybatis.annotation.mapper;

import com.ibranco.mybatis.annotation.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from newuser")
    List<User> findAll();

    @Insert("insert into newuser (username,password,rid,name) values (#{username},#{password},#{rid},#{name})")
    void saveUser(User user);

    @Update("update newuser set username=#{username},password=#{password},rid=#{rid},name=#{name} where id = #{id}")
    void updateUser(User user);

    @Select("select * from newuser where id = #{id}")
    User findById(Integer id);

    @Delete("delete from newuser where id = #{id}")
    void deleteById(Integer id);
}
