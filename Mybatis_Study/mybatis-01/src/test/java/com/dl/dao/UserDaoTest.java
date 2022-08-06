package com.dl.dao;

import com.dl.pojo.User;
import com.dl.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class UserDaoTest {

        static Logger logger = Logger.getLogger(UserDaoTest.class);



        @Test
        public void testLimit2(){
            //创建分页对象 从0开始，每页2条数据
            RowBounds rowBounds = new RowBounds(0, 2);
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            List<User> list = sqlSession.selectList("com.dl.dao.UserMapper.getLimit2",null,rowBounds);
            for (User user : list) {
                System.out.println(user);
            }
            sqlSession.close();
        }


        @Test
        public void getLimit(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("startIndex",0);
            map.put("pageSize",2);
            List<User> list = mapper.getLimit(map);
            for (User user : list) {
                System.out.println(user);
            }
            sqlSession.close();

        }



        @Test
        public void testLog4j(){
            logger.info("info:进入了log4j");
            logger.debug("debug:进入了log4j");
            logger.error("error:进入了log4j");
        }

    @Test
    public void test(){
        // 获得SQLSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            // 方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            // 方式二：
            //List<User> userList = sqlSession.selectList("com.dl.dao.UserDao.getUserList");
            //遍历
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close(); //sqlSession要在finally中关闭，所以手动加 try-catch
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.addUser(new User(4, "小白", "123456"));
        if(row > 0){
            System.out.println("插入成功！");
        }
        //提交事务,不提交则插入不成功
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",6);
        map.put("userName","测试map");
        map.put("pwd","111111");
        int row = mapper.addUser2(map);
        if(row > 0){
            System.out.println("插入成功！");
        }
        //提交事务,不提交则插入不成功
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.updateUser(new User(4, "xiaobai", "111111"));
        if (row > 0){
            System.out.println("修改成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.deleteUser(4);
        if (row > 0){
            System.out.println("删除成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }



}
