/**
 * 
 */
package com.demo.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @description 
 * @author lzq
 * @date 2018年4月3日 下午7:06:03
 */
@Configuration
public class BeanConfiguration {
    @Bean
    @Profile("dev")
    public Runnable test1() {
        System.out.println("开发环境使用的 Bean");
        return () -> {};
    }
    
    @Bean
    @Profile("test")
    public Runnable test2() {
        System.out.println("测试环境使用的 Bean");
        return () -> {};
    }
    
    @Bean
    @Profile("pro")
    public Runnable test3() {
        System.out.println("生成环境使用的 Bean");
        return () -> {};
    }
}