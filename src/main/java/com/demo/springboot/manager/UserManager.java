/**
 * 
 */
package com.demo.springboot.manager;

import com.demo.springboot.model.User;

/**
 * @description 
 * @author lzq
 * @date 2018年4月4日 下午8:15:46
 */
public interface UserManager {
    public int insert(User user);
    
    public int deleteById(Integer id);
    
    public int update(User user);
    
    public User getById(Integer id);
}