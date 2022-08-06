package com.dl.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 扫描mapper接口所在的包-扫描指定包下的接口：
@MapperScan("com.dl.mapper")
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor pagination = new PaginationInnerInterceptor();
        pagination.setDbType(DbType.MYSQL);
        // 溢出总页数后是否进行处理:默认值：false-不处理 true-处理
//        pagination.setOverflow(true);
        // 单页分页条数限制(默认无限制,参见 插件#handlerLimit 方法)
        pagination.setMaxLimit(500L);
        // 添加分页插件：
        interceptor.addInnerInterceptor(pagination);
        // 添加乐观锁插件：
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }


}
