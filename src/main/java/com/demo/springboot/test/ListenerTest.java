/**
 * 
 */
package com.demo.springboot.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @description 自定义监听器
 * @author lzq
 * @date 2018年4月4日 下午4:43:47
 */
public class ListenerTest implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器初始化...");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}