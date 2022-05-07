package com.cloud.yejiang.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Description:
 * date: 2022/5/3 22:04
 * @author YeJiang
 * @version
 */

//@Configuration
public class MyConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //重写后很多原有默认设置都没了
        //super.configure(http);
        http.formLogin()
                .loginPage("/login.html")
                //两个层次：
                //1. 当发现/login1 时认为是登录，需要执行 UserDetailsServiceImpl
                //2. 表单必须和这里配置的url一致
                .loginProcessingUrl("/login1")
                //.defaultSuccessUrl("/hello", true)
                .successForwardUrl("/success") //此处是 post 请求
                .failureForwardUrl("/hello")
                .permitAll()
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

                        System.out.println("测试 。。");
                        //e.printStackTrace();
                        //判断异常信息 跳转不同页面，比如密码过期重置
                        request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
                        //记录登录失败次数 禁止登录
                    }
                });
        //开启csrf防护
        //http.csrf().disable();
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        http.authorizeRequests().antMatchers("/**").authenticated();
    }

    //内存中存储用户
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("yejiang1").password("yejiang1").roles("admin")
//                .and()
//                .withUser("yejiang2").password("yejiang2").roles("admin2");
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("yejiang3").password("yejiang3").roles("admin").build());
//        manager.createUser(User.withUsername("yejiang4").password("yejiang4").roles("admin").build());
//        return manager;
//    }

    @Autowired
    private DataSource dataSource;

    //db中存储用户
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).getUserDetailsService()
        .createUser(User.withUsername("yejiang1").password("yejiang1").roles("admin").build());
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
//        if (!manager.userExists("yejiang1")) {
//            manager.createUser(User.withUsername("yejiang1").password("yejiang1").roles("admin").build());
//        }
//        return manager;
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
