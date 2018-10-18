/**
 * 
 */
package com.demo.springboot.manager;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.springboot.model.User;


/**
 * @description 
 * @author lzq
 * @date 2018年4月4日 下午8:20:00
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerTest{
    
    @Autowired
    private UserManager userManager;

    @Test
    public void testInsert() {
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("zhangsan");
        user.setBirthday(new Date());
        
        int result = this.userManager.insert(user);
        System.out.println(result);
    }
    
    @Test
    public void testGetById() {
        User user = this.userManager.getById(1);
        System.out.println(user.getUsername());
    }
    
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1);
        user.setPassword("zhangsan123");
        this.userManager.update(user);
    }
    
    @Test
    public void testDeleteById() {
        int result = this.userManager.deleteById(1);
        System.out.println(result);
    }

}
