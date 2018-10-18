/**
 * 
 */
package com.demo.springboot;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;

import com.demo.springboot.test.ListenerTest;
import com.demo.springboot.test.ServletTest;
import com.demo.springboot.test.TimeFilter;

/**
 * @description 针对自定义 Servlet、Filter 和 Listener 的配置
 * @author lzq
 * @date 2018年4月4日 下午4:46:27
 */
@EnableCaching
@SpringBootApplication
public class SpringbootWebApplication implements ServletContextInitializer {
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 配置 Servlet
        servletContext.addServlet("servletTest",new ServletTest())
                      .addMapping("/servletTest");
        // 配置过滤器
        servletContext.addFilter("timeFilter",new TimeFilter())
                      .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
        // 配置监听器
        servletContext.addListener(new ListenerTest());
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }
}