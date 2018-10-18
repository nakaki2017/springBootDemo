/**
 * 
 */
package com.demo.springboot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 
 * @author lzq
 * @date 2018年4月4日 下午4:01:06
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
    @RequestMapping("hello")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf");
        return "hello";
    }
    
    
    
    @RequestMapping("/websocket/test")
    public String websocket() {
        return "websocket";
    }
}