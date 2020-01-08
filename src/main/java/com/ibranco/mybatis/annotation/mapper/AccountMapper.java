package com.ibranco.mybatis.annotation.mapper;

import com.ibranco.mybatis.annotation.domain.Account;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {

    @Select("select * from account")
    @Results( id = "accountMap",value = {@Result(id=true,column = "id",property = "aid"),@Result(column = "uid",property = "userid"),@Result(column = "name",property = "aname"),@Result(column = "money",property = "amoney")})
    List<Account> findAll();

    @Select("select * from account where id = #{id}")
    @ResultMap("accountMap")
    Account findById(Integer id);
}
