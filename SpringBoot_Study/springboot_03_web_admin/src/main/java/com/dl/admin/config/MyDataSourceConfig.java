package com.dl.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Deprecated
// 使用配置文件的方式配置，也可以使用starter
//@Configuration
public class MyDataSourceConfig {

    //@Bean
    //@ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        // 加入监控功能,加入防火墙功能:
        druidDataSource.setFilters("stat,wall");
        //可以通过配置文件配置:
//        druidDataSource.setUrl("");
//        druidDataSource.setUsername("");
//        druidDataSource.setPassword("");
//        druidDataSource.setDriverClassName("");
        return druidDataSource;
    }

    /**
     * 设置druid的监控页
     */
    //@Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(statViewServlet,"/druid/*");
        // 参数名字不可以变： loginUsername loginPassword
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","admin");
//        // 设置谁可以访问：allow ,如果值为""那么就是所有人都可以访问
//        statViewServletServletRegistrationBean.addInitParameter("allow","");
//        // 设置谁不可以访问：
//        statViewServletServletRegistrationBean.addInitParameter("loginPassword","admin");
        return statViewServletServletRegistrationBean;
    }

    /**
     * Web关联监控配置
     * WebStatFilter用于采集web-jdbc关联监控的数据。
     */
    //@Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return webStatFilterFilterRegistrationBean;
    }

}
