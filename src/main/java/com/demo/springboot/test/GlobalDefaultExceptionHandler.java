/**
 * 
 */
package com.demo.springboot.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description 全局异常捕获
 * 
 * 如果项目前后端是通过 JSON 进行数据通信，则当出现异常时可以常用如下方式处理异常信息。
 * 
 * 编写一个类充当全局异常的处理类，需要使用 @ControllerAdvice 和 @ExceptionHandler 注解：
 * @author lzq
 * @date 2018年4月4日 下午4:54:40
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    /**
     * 处理 Exception 类型的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> defaultExceptionHandler(Exception e) {
        
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", 500);
        map.put("msg", e.getMessage());
        return map;
    }
}