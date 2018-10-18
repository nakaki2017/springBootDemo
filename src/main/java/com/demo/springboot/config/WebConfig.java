/**
 * 
 */
package com.demo.springboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.demo.springboot.test.ListenerTest;
import com.demo.springboot.test.ServletTest;
import com.demo.springboot.test.TimeFilter;
import com.demo.springboot.test.TimeInterceptor;

/**
 * @description 属性装配
 * 
 * 2种方式
 * 通过 @Value 获取 config.userName 配置；
 * 通过 environment 获取 config.password 配置。
 * 
 * 
 * 
 * 常用注解
 * @Configuration                 # 作用于类上，相当于一个 xml 配置文件
 * @Bean                          # 作用于方法上，相当于 xml 配置中的 <bean>
 * @SpringBootApplication         # Spring Boot的核心注解，是一个组合注解，用于启动类上
 * @EnableAutoConfiguration       # 启用自动配置，允许加载第三方 Jar 包的配置
 * @ComponentScan                 # 默认扫描 @SpringBootApplication 所在类的同级目录以及它的子目录
 * @PropertySource                # 加载 properties 文件
 * @Value                         # 将配置文件的属性注入到 Bean 中特定的成员变量
 * @EnableConfigurationProperties # 开启一个特性，让配置文件的属性可以注入到 Bean 中，与 @ConfigurationProperties 结合使用
 * @ConfigurationProperties       # 关联配置文件中的属性到 Bean 中
 * @Import                        # 加载指定 Class 文件，其生命周期被 Spring 管理
 * @ImportResource                # 加载 xml 文件
 * 
 * @author lzq
 * @date 2018年4月3日 下午7:14:12
 */
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{
    
    
    
    @Value("${ds.userName}")
    private String userName;
    
    
    @Autowired
    private Environment environment;
    
    
    
    public void show() {
        System.out.println("ds.userName:" + this.userName);
        System.out.println("ds.password:" + this.environment.getProperty("ds.password"));
    }
    
    
    
    //整合 Fastjson
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        
        return new HttpMessageConverters(converter);
    }
    
    //将 Servelt 注册成 Bean
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new ServletTest(),"/servletTest");
    }
    
    //将 Filter 注册成 Bean
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);
        
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        
        return registrationBean;
    }
    
    //注册监听器为 Bean
    @Bean
    public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
    }
    
    
    //编写拦截器后，我们还需要将其注册到拦截器链中
    @Autowired
    private TimeInterceptor timeInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
    
    
    //CORS支持 粗粒度控制：  方式1
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
          @Override
          public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/fastjson/**")
                      .allowedOrigins("http://localhost:8088");// 允许 8088 端口访问
          }
        };
    }
    
    
    //CORS支持 粗粒度控制： 方式2
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/fastjson/**")
              .allowedOrigins("http://localhost:8088");// 允许 8088 端口访问
    }
    
    //CORS支持 细粒度控制：在 FastJsonController 类中的方法上添加 @CrossOrigin(origins=”xx”) 注解
    
    
    
    
}