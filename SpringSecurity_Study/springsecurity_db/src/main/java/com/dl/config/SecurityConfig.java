package com.dl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //jdbcTokenRepository.setCreateTableOnStartup(true); //自动创建表
        return jdbcTokenRepository;
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 自定义没有权限的页面-设置403没有权限，访问被拒绝页面：
        http.exceptionHandling()
                .accessDeniedPage("/noPermission.html");

        // 退出功能：
        http.logout().logoutUrl("/logout") //处理退出登录的请求，名字可以随便起，但要和表单的处理请求一致，SpringSecurity自动生成
                .logoutSuccessUrl("/test/test02").permitAll();

        http.formLogin()
                .loginPage("/login.html") //自定义登录页面
                .loginProcessingUrl("/sys/login") //处理登录的请求，名字可以随便起，但要和表单的处理请求一致，SpringSecurity自动生成
                .defaultSuccessUrl("/success.html")
                .permitAll()//登录成功后跳转的请求
                //.failureForwardUrl("/login.html") //登录失败后跳转的请求
                //.usernameParameter("")  // 指定登陆表单的用户名参数的name，默认是username
                // .passwordParameter("") // 指定登陆表单的密码参数的name，默认是password
                //.permitAll()
                .and().authorizeRequests() //具有指定的权限（角色）才能访问这个请求
                        // permitAll()：这些（个）请求所有的人都可以访问，即不需要登录认证就可以访问
                        //.antMatchers("/","/test/hello").permitAll()
                        // hasAuthority(String)：这些（个）请求具有admin的权限才可以访问，需要登陆
                        //.antMatchers("/test/test01").hasAuthority("admin")
                        // hasAnyAuthority(..String)：这些（个）请求具有admin或admin1权限才可以访问，需要登陆
                        //.antMatchers("/test/test02").hasAnyAuthority("admin","admin1")
                        // hasRole(String)：这些（个）请求只有角色role才可以访问，需要登陆
                        //.antMatchers("/test/test01").hasRole("role1")
                         // hasAnyRole(..String)：这些（个）请求只有角色role1和role2才可以访问，需要登陆
                        //.antMatchers("/test/test02").hasAnyRole("role1","role2")
                        .antMatchers("/test/hello").hasRole("role1")
                        .antMatchers("/success.html").hasRole("role1")
                //.anyRequest().authenticated() // 所有请求都要认证
                .and()
               .csrf().disable(); //关闭csrf防护

        //记住我：
        http.rememberMe()
                .userDetailsService(userDetailsService)
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60*60);

    }
}
