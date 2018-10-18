/**
 * 
 */
package com.demo.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @description 
 * Spring Data Redis 为我们提供 RedisTemplate 和 StringRedisTemplate 两个模板进行数据操作，它们主要 的访问方法如下：
 * 
 * 方法  说明
 * opsForValue()   操作简单属性的数据
 * opsForList()    操作含有 list 的数据
 * opsForSet() 操作含有 set 的数据
 * opsForZSet()    操作含有 zset 的数据
 * opsForHash()    操作含有 hash 的数据
 * 
 * @author lzq
 * @date 2018年4月11日 下午8:12:31
 */
@Component
public class RedisDao {
  @Autowired
  private StringRedisTemplate stringRedisTemplate;
  public void set(String key, String value) {
    this.stringRedisTemplate.opsForValue().set(key, value);
  }
  public String get(String key) {
    return this.stringRedisTemplate.opsForValue().get(key);
  }
  public void delete(String key) {
    this.stringRedisTemplate.delete(key);
  }
}
