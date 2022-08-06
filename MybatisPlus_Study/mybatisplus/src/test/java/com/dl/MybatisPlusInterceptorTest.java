package com.dl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dl.mapper.ProductMapper;
import com.dl.mapper.UserMapper;
import com.dl.pojo.Product;
import com.dl.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusInterceptorTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProductMapper productMapper;

    /**
     * 如果返回类型是 IPage 则入参的 IPage 不能为null,因为 返回的IPage == 入参的IPage
     * 如果返回类型是 List 则入参的 IPage 可以为 null(为 null 则不分页),但需要你手动 入参的IPage.setRecords(返回的 List);
     * 如果 xml 需要从 page 里取值,需要 page.属性 获取
     */
    @Test
    public void testPagination(){
        /**
         * SELECT id,name,age,email,is_deleted FROM user WHERE is_deleted=0 LIMIT ?
         */
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent()); // 当前页
        System.out.println(page.getSize()); // 页面大小
        System.out.println(page.getTotal()); // 总记录数
        System.out.println(page.getPages());  // 总页数
        System.out.println(page.hasPrevious());
        System.out.println(page.hasNext());
    }

    /**
     * 测试：根据年龄查询用户列表，分页显示，自己定义的方法
     *  select * from user where age > ? LIMIT ?
     */
    @Test
    public void testMyPage(){
        Page<User> page = new Page<>(1, 2);
        userMapper.selectMyPage(page,20);
        List<User> records = page.getRecords();
        records.forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void testProduct(){
        // 1.小李获取商品价格：
        Product productLi = productMapper.selectById(1L);
        System.out.println("小李取出的价格：" + productLi.getPrice());
        // 2.小王获取商品价格：
        Product productWang = productMapper.selectById(1L);
        System.out.println("小王取出的价格：" + productWang.getPrice());
        // 3.小李将价格加了50元，存入数据库
        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);
        // 4.小王将商品减了30元，存了数据库
        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if (result == 0) {
            productWang = productMapper.selectById(1L);
            productWang.setPrice(productWang.getPrice()-30);
            productMapper.updateById(productWang);
        }
        // 最后的结果
        Product product = productMapper.selectById(1L);
        System.out.println("老板查询的价格：" + product.getPrice());
    }






}
