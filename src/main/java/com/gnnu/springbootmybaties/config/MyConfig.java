package com.gnnu.springbootmybaties.config;

import com.gnnu.springbootmybaties.pojo.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         //配置拦截器
          registry.addInterceptor(new SessionHandlerInterceptors()).addPathPatterns("/admin/**").excludePathPatterns("/login","/login.html","/","/css/**","/images/**","/js/**","/json/**","/layui/**","/page/**");
    }
    class SessionHandlerInterceptors implements HandlerInterceptor{

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            User user =(User) request.getSession().getAttribute("user");
            if(user==null){
                response.sendRedirect("login");
                return false;
            }
            return true;
        }
    }
}
