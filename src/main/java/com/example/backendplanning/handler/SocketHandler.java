package com.example.backendplanning.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        while (true) {
//            session.sendMessage(new TextMessage("hoi"));
//            Thread.sleep(1000);
//        }
        System.out.println("test");
    }
}
