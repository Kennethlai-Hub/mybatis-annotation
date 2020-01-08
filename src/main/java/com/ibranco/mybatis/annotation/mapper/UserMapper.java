package com.ibranco.mybatis.annotation.mapper;

import com.ibranco.mybatis.annotation.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace(blocking = true)
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

    @Select("select * from newuser")
    @Results(value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "rid",property = "rid"),
            @Result(column = "name",property = "name"),
            @Result(column = "id",property = "accounts",
                    many = @Many(select = "com.ibranco.mybatis.annotation.mapper.AccountMapper.findByUid",fetchType = FetchType.LAZY)),
    })
    List<User> findAllUserAA();
}
