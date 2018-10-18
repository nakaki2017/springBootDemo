/**
 * 
 */
package com.demo.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.demo.springboot.test.WebSocketServer;

/**
 * @description WebSocket 配置类
 * @author lzq
 * @date 2018年4月4日 下午5:23:26
 */
//如果使用该方式实现 WebSocket 功能并打包成 war 运行会报错：
//javax.websocket.DeploymentException: Multiple Endpoints may not be deployed to the same path
//而且我使用这种方法，跑junit也会报错说error create bean ServerEndpointExporter
//@Configuration
//public class WebSocketConfig {
//    
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
//}
//该方式适用于 jar 包方式运行和 war 方式运行。
@Configuration  
@EnableWebSocket  
public class WebSocketConfig implements WebSocketConfigurer {  
    @Override  
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {  
        registry.addHandler(webSocketServer(), "/webSocketServer/*"); 
    }  
  
    @Bean
    public WebSocketHandler webSocketServer() {  
        return new WebSocketServer();  
    }  
}