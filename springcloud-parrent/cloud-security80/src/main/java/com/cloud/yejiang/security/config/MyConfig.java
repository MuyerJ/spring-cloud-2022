package com.cloud.yejiang.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 
 * date: 2022/5/3 22:04
 * @author YeJiang
 * @version
 */

@Configuration
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
        http.authorizeRequests().antMatchers("/**").authenticated();

    }
}
