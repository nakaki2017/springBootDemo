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
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.demo.springboot.test.ListenerTest;
import com.demo.springboot.test.ServletTest;
import com.demo.springboot.test.TimeFilter;

/**
该注解指定项目为springboot，由此类当作程序入口
自动装配 web 依赖的环境

**/
//@SpringBootApplication
public class SpringbootApplication  extends SpringBootServletInitializer{
   
//   public static void main(String[] args) {
       //普通运行
//       SpringApplication.run(SpringbootApplication.class, args);
       
       //属性装配
//       ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
//       context.getBean(WebConfig.class).show();
       
       //对象装配
//       ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
//       context.getBean(DataSourceProperties.class).show();
       
//   }
    
    
    //
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(SpringbootApplication.class);
//    }
//    public static void main(String[] args) {
////        ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
////        Map<String, EncodingConvertor> map = context.getBeansOfType(EncodingConvertor.class);
////        System.out.println(map);
//        
//        ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
//        System.out.println(System.getProperty("file.encoding"));
//        Map<String, EncodingConvertor> map = context.getBeansOfType(EncodingConvertor.class);
//        System.out.println(map);
//    }
    
    
    
}