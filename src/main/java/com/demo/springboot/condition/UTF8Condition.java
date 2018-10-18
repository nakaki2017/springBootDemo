/**
 * 
 */
package com.demo.springboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @description 当我们需要根据系统环境的字符集选择性的装配其中一个 Bean 时，需要结合 @Conditional 注解 和 Condition 接口使用。如下：
 * 条件类
 * @author lzq
 * @date 2018年4月4日 下午1:53:35
 */
public class UTF8Condition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String encoding = System.getProperty("file.encoding");
        if (encoding != null) {
            return "utf-8".equals(encoding.toLowerCase());
        }
        return false;
    }
}
