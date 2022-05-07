package com.cloud.yejiang.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * Description: 测试权限
 * date: 2022/5/7 13:27
 * @author YeJiang
 * @version
 */

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MyConfigAuthority extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //权限
        http.authorizeRequests()
                //.antMatchers("/admin/**").hasRole("admin")
                //.antMatchers("/api/**").hasRole("api")
                .anyRequest().authenticated();

        //登录
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login1")
                .successForwardUrl("/success")
                .failureForwardUrl("/hello")
                .permitAll()
                .failureHandler((request, response, e) -> {
                    System.out.println("failureHandler ~");
                    request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
                });
        http.logout().addLogoutHandler((request, response, authentication) -> {
            System.out.println("addLogoutHandler ~");

        });

        http.exceptionHandling().accessDeniedPage("/403.html");

        //安全
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }


    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        if (!manager.userExists("yejiang1")) {
            manager.createUser(User.withUsername("yejiang1").password("yejiang1").roles("admin").build());
        }
        if (!manager.userExists("yejiang2")) {
            manager.createUser(User.withUsername("yejiang2").password("yejiang2").roles("api").build());
        }
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
