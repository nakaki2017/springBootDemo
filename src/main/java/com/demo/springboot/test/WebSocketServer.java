/**
 * 
 */
package com.demo.springboot.test;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @description WebSocket 处理类
 * @author lzq
 * @date 2018年4月4日 下午5:23:51
 */
/*@ServerEndpoint(value = "/webSocketServer/{userName}")
@Component
public class WebSocketServer {
    
    private static final Set<WebSocketServer> connections = new CopyOnWriteArraySet<>();
    private String nickname;
    private Session session;
    private static String getDatetime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    @OnOpen
    public void start(@PathParam("userName") String userName, Session session) {
        this.nickname = userName;
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickname, "加入聊天！");
        broadcast(message);
    }
    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("* %s %s", nickname, "退出聊天！");
        broadcast(message);
    }
    @OnMessage
    public void pushMsg(String message) {
        broadcast("【" + this.nickname + "】" + getDatetime(new Date()) + " : " + message);
    }
    @OnError
    public void onError(Throwable t) throws Throwable {
    }
    private static void broadcast(String msg) {
        // 广播形式发送消息
        for (WebSocketServer client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    e.printStackTrace();
                }
                String message = String.format("* %s %s", client.nickname, "断开连接");
                broadcast(message);
            }
        }
    }
}*/
public class WebSocketServer extends TextWebSocketHandler {
    private static final Map<WebSocketSession, String> connections = new ConcurrentHashMap<>();
    private static String getDatetime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    
    /**
     * 建立连接
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String uri = session.getUri().toString();
        String userName = uri.substring(uri.lastIndexOf("/") + 1);
        
        String nickname = URLDecoder.decode(userName, "utf-8");
        connections.put(session, nickname);
        String message = String.format("* %s %s", nickname, "加入聊天！");
        broadcast(new TextMessage(message));
    }
    /**
     * 断开连接
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String nickname = connections.remove(session);
        String message = String.format("* %s %s", nickname, "退出聊天！");
        
        broadcast(new TextMessage(message));
    }
    /**
     * 处理消息
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = "【" + connections.get(session) + "】" + getDatetime(new Date()) + " : " + message.getPayload();
        
        broadcast(new TextMessage(msg));
    }
    private static void broadcast(TextMessage msg) {
        // 广播形式发送消息
        for (WebSocketSession session : connections.keySet()) {
            try {
                synchronized (session) {
                    session.sendMessage(msg);
                }
            } catch (Exception e) {
                connections.remove(session);
                try {
                    session.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String message = String.format("* %s %s", connections.get(session), "断开连接");
                broadcast(new TextMessage(message));
            }
        }
    }
}