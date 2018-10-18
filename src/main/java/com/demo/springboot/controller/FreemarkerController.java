/**
 * 
 */
package com.demo.springboot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 
 * @author lzq
 * @date 2018年4月4日 下午3:52:42
 */
@Controller
@RequestMapping("freemarker")
public class FreemarkerController {
    @RequestMapping("hello")
    public String hello(Map<String,Object> map) {
        
        map.put("msg", "Hello Freemarker");
        return "hello";
    }
    @RequestMapping("/websocket/test")
    public String websocket() {
        return "websocket";
    }
}