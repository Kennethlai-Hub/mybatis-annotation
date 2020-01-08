package com.ibranco.mybatis.annotation.test;

import com.ibranco.mybatis.annotation.domain.Account;
import com.ibranco.mybatis.annotation.domain.User;
import com.ibranco.mybatis.annotation.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private Logger logger = Logger.getLogger(AccountTest.class);
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountMapper accountMapper;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.close();
        inputStream.close();

    }
    @Test
    public void testFindAll(){
        List<Account> list = accountMapper.findAll();
        for(Account item:list){
            logger.info(item);
        }
    }

    @Test
    public void testFindById(){
        Account list = accountMapper.findById(4);

            logger.info(list);

    }


}
