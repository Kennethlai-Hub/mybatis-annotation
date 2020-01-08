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

public class AnnotationTest {
    private Logger logger = Logger.getLogger(AnnotationTest.class);
    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserMapper userMapper;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.close();
        inputStream.close();

    }

    @Test
    public void testFindAll(){
        List<User> list = userMapper.findAll();
        for(User item:list){
            logger.info(item);
        }
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("mybatis");
        user.setPassword("3166");
        user.setRid(1);
        user.setName("king");
        userMapper.saveUser(user);
    }
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(4);
        user.setUsername("mybatis88");
        user.setPassword("316699");
        user.setRid(2);
        user.setName("kings");
        userMapper.updateUser(user);
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(4);
        logger.info(user);
    }

    @Test
    public void testDeleteById(){
        userMapper.deleteById(4);
    }
}
