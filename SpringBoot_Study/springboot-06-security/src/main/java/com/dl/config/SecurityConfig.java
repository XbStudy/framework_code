package com.dl.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SpringSecurity的配置类：
 *  添加@EnableWebSecurity注解
 *  继承WebSecurityConfigurerAdapter类
 *  重写方法
 *  定义规则
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 授权:
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        // 开启登录和注销功能
//        http.formLogin(); // 登录： /login
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/toLogin").loginProcessingUrl("/login");
//        http.logout();  // 注销：  /logout
        http.logout().logoutSuccessUrl("/"); //注销后跳转到指定的url

        // 开启记录我功能：cookie
//        http.rememberMe();
        http.rememberMe().rememberMeParameter("remember");

        // 禁用csrf：
        http.csrf().disable();
    }

    /**认证:
     * 密码需要进行编码否则报错，
     * 在SpringSecurity5.0+新增了很多加密
     * PasswordEncoder:密码编码器
     *     会对我们输入的密码进行编码,所以我们的密码传到后台是编码后过的
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中模拟信息:正常情况是在数据库中读取数据
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("xiaobai").password(new BCryptPasswordEncoder().encode("111111")).roles("vip1")
                .and() //连接下一个角色信息
                .withUser("root").password(new BCryptPasswordEncoder().encode("111111")).roles("vip1","vip2","vip3");
    }
}
