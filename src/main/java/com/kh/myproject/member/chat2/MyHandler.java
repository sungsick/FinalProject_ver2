package com.kh.myproject.member.chat2;

import com.kh.myproject.member.chat2.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


// 이 클래스에서 실제 클라이언트간의 채팅과 관련된 모든 로직이 수행된다.
@Service
@SessionAttributes("user")
public class MyHandler extends TextWebSocketHandler {

    Map<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵

    @Autowired
    ChatRoomService chatRoomService;

    @Autowired
    WebChatController webChatController;


    HashMap<String, WebSocketSession> userList = new HashMap<>();



    // 소켓 연결이 완료됐을 때 실행되는 메서드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {


        userList.put(session.getId(),session);

        WebSocketSession wss = sessionMap.get("a");
        System.out.println("연결완료");
        System.out.println(session);
//        session.getAttributes();

    }


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message){

        // 메시지를 보냈을떄 본인을 제외한 나머지 사람에게 메시지를 보낸다.

        for(String key : userList.keySet()){

            WebSocketSession wss = userList.get(key);
            if(!session.getId().equals(wss.getId())){ // 메시지를 보낸 사람과 userList에 서로 다른 사람일때만 메시지를 보낸다.

                try {
                    wss.sendMessage(message); // 해당 세션으로 메시지를 보낸다.
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }


        try {
            session.sendMessage(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

        System.out.println("error");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

        System.out.println("close");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
