/**
 * 
 */
package com.demo.springboot.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.springboot.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @description 
 * CORS支持    细粒度控制：在 FastJsonController 类中的方法上添加 @CrossOrigin(origins=”xx”) 注解：
 * @author lzq
 * @date 2018年4月4日 下午4:16:17
 */
@Api(value = "FastJson测试", tags = { "测试接口" })
@Controller
@RequestMapping("fastjson")
@CrossOrigin(origins="http://localhost:8088")
public class FastJsonController {
    
    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
//    @RequestMapping("/test")
    //上边的方法是用 @GetMapping 注解，如果只是使用 @RequestMapping 注解，不配置 method 属性，那么 API 文档会生成 7 种请求方式。
    @GetMapping("/test")
    @ResponseBody
    public User test() {
        User user = new User();
        
        user.setId(1);
        user.setUsername("jack");
        user.setPassword("jack123");
        user.setBirthday(new Date());
        
//        // 模拟异常
//        int i = 1/0;
        
        return user;
    }
}