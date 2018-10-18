/**
 * 
 */
package com.demo.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 
 * @author lzq
 * @date 2018年4月3日 下午6:57:38
 */
@RestController
public class TestController {
    @GetMapping("/helloworld")
    public String helloworld() {
        return "helloworld";
    }
    @GetMapping("/helloworld2")
    public String helloworld2() {
        return "helloworld2";
    }
    
    
}