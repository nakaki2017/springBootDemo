/**
 * 
 */
package com.demo.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description 对象装配
 * 
 * 
 * @author lzq
 * @date 2018年4月3日 下午7:19:15
 */
@Component
@ConfigurationProperties(prefix="ds")
public class DataSourceProperties {
    private String url;
    
    private String driverClassName;
    
    private String userName;
    
    private String password;
    
    
    public void show() {
        System.out.println("ds.url=" + this.url);
        System.out.println("ds.driverClassName=" + this.driverClassName);
        System.out.println("ds.userName=" + this.userName);
        System.out.println("ds.password=" +this.password);
    }
}