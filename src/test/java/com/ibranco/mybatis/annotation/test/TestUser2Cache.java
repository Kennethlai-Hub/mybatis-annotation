package com.ibranco.mybatis.annotation.test;

import com.ibranco.mybatis.annotation.domain.User;
import com.ibranco.mybatis.annotation.mapper.UserMapper;
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

public class TestUser2Cache {
    private Logger logger = Logger.getLogger(TestUser2Cache.class);
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
    }
    @After
    public void destory() throws IOException {
        inputStream.close();

    }



    @Test
    public void test2Cache(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = userMapper1.findById(1);
        logger.info(user1);
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.findById(1);
        logger.info(user2);
        sqlSession2.close();

        logger.info(user1 == user2);
    }
}
