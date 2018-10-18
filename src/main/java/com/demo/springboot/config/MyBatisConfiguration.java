/**
 * 
 */
package com.demo.springboot.config;

import java.io.IOException;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @description 
 * 
 * 此方式也需要在 applicaton.properties 配置数据库连接，当不需要在文件中配置 mybatis 相关参数。
 * 
 * 以上便是两种方式的配置的不同之处。
 * 
 * 在 src/main/resources 下创建 mybatis 文件夹，并在 mybatis 文件夹中创建 “mybatis-config.xml” 配置文件，mybatis 文件夹下再创建一个 “mapper” 文件夹，里边存放 Mpper 接口对应的 mapper 映射文件。
 * 
 * @author lzq
 * @date 2018年4月7日 上午1:11:12
 */
@Configuration
public class MyBatisConfiguration {
    
    
    @Bean
    @ConditionalOnMissingBean // 当容器里没有指定的 Bean 的情况下创建该对象
    public SqlSessionFactoryBean sqlSessionFactory(DruidDataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        
        // 设置mybatis的主配置文件
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        
        // 设置mapper映射文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] mapperXml = resolver.getResources("classpath:mybatis/mapper/*.xml");
        sqlSessionFactoryBean.setMapperLocations(mapperXml);
        
        // 设置别名包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.demo.domain");
        return sqlSessionFactoryBean;
    }
    @Bean
    @ConditionalOnBean(SqlSessionFactoryBean.class) // 当 SqlSessionFactoryBean 实例存在时创建对象
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.demo.springboot.mapper");
        return mapperScannerConfigurer;
    }
}