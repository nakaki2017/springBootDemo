/**
 * 
 */
package com.demo.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.demo.springboot.condition.GBKCondition;
import com.demo.springboot.condition.UTF8Condition;
import com.demo.springboot.converter.EncodingConvertor;
import com.demo.springboot.converter.GBKEncodingConvertor;
import com.demo.springboot.converter.UTF8EncodingConvertor;

/**
 * @description 除了 @Conditional 之外，Spring Boot 还提供了其他注解进行条件装配：
 * @ConditionalOnBean              # 当指定 Bean 存在时进行装配
 * @ConditionalOnMissingBean       # 当指定 Bean 不存在时进行装配
 * @ConditionalOnClass             # 当指定 Class 在 classpath 中时进行装配
 * @ConditionalOnMissingClass      # 当指定 Class 不在 classpath 中时进行装配
 * @ConditionalOnExpression        # 根据 SpEL 表达式进行装配
 * @ConditionalOnJava              # 根据 JVM 版本进行装配
 * @ConditionalOnJndi              # 根据 JNDI 进行装配
 * @ConditionalOnWebApplication    # 当上下文是 WebApplication 时进行装配
 * @ConditionalOnNotWebApplication # 当上下文不是 WebApplication 时进行装配
 * @ConditionalOnProperty          # 当指定的属性名的值为指定的值时进行装配
 * @ConditionalOnResource          # 当指定的资源在 classpath 中时进行装配
 * @ConditionalOnCloudPlatform     # 
 * @ConditionalOnSingleCandidate   #
 * 
 * @author lzq
 * @date 2018年4月4日 下午1:47:13
 */
@Configuration
public class EncodingConvertorConfiguration {
//    @Bean
//    public EncodingConvertor createUTF8EncodingConvertor() {
//        return new UTF8EncodingConvertor();
//    }
//    
//    @Bean
//    public EncodingConvertor createGBKEncodingConvertor() {
//        return new GBKEncodingConvertor();
//    }
    
    //Condition 用于判断是否进行装配，需要实现 matches 方法。当方法返回 true 时表示需要装配，否则反之。
    //在对应的 Bean 上添加 @Conditional 注解。
    @Bean
    @Conditional(UTF8Condition.class)
    public EncodingConvertor createUTF8EncodingConvertor() {
        return new UTF8EncodingConvertor();
    }
    
    @Bean
    @Conditional(GBKCondition.class)
    public EncodingConvertor createGBKEncodingConvertor() {
        return new GBKEncodingConvertor();
    }
}
