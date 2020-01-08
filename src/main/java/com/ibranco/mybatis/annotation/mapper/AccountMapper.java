package com.ibranco.mybatis.annotation.mapper;

import com.ibranco.mybatis.annotation.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountMapper {

    @Select("select * from account")
    @Results( id = "accountMap",value = {
            @Result(id=true,column = "id",property = "aid"),
            @Result(column = "uid",property = "userid"),
            @Result(column = "name",property = "aname"),
            @Result(column = "money",property = "amoney"),
            @Result(property = "user",column = "uid",one=
            @One(select ="com.ibranco.mybatis.annotation.mapper.UserMapper.findById",fetchType = FetchType.DEFAULT))
    })
    List<Account> findAll();

    @Select("select * from account where id = #{id}")
    @ResultMap("accountMap")
    Account findById(Integer id);

    @Select("select * from account where uid = #{uid}")
    @ResultMap("accountMap")
    List<Account> findByUid(Integer id);
}
