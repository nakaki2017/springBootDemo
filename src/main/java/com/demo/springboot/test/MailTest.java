/**
 * 
 */
package com.demo.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description 
 * @author lzq
 * @date 2018年4月4日 下午6:54:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
    @Autowired
    private JavaMailComponent javaMailComponent;
    
    @Test
    public void test() {
        this.javaMailComponent.sendMail("707795647@qq.com");
    }
}
