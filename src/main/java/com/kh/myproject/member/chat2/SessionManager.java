package com.kh.myproject.member.chat2;


import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionManager {

    // 실시간으로 소켓 통신이 이뤄질때마다 해당 정보를 잠시 가지고 있는 Map객체.
    // 메시지를 전송할떄는 두가지 동작이 시행된다.
    // 1. 나와같은 roomId를 가진 나를 제외한 나머지 1명의 소켓 세션 아이디에 메시지를 전송한다(send)
    // --> sessions에 roomId를 통해 session을 찾는다. 두개밖에 나오지 않을 것이다.
    // 2. 그와 별개로 db에는 또 chatMessage 객체를 insert한다.
    // 그러면 한쪽만 소켓 연결이 돼있더라도 나머지 한쪽은 다음번 접속시에 메시지를 수신할 수 있을 것이고
    // 접속했다면 실시간으로 통신이 가능한 것이다.


    private final Map<Long, Map<Long,WebSocketSession>> roomList = new ConcurrentHashMap<>();

    public void addSession(Long roomId, Long userNumber, WebSocketSession session) {

        Map<Long, WebSocketSession> sessions = new HashMap<>();
        sessions.put(userNumber,session);
        roomList.put(roomId,sessions);
    }


    public WebSocketSession getSession(Long roomId ,Long userNumber) {

        System.out.println("getSession메서드 실행");
        Map<Long,WebSocketSession> chatRoom = roomList.get(roomId);
        WebSocketSession session = null;

        System.out.println("roomList" +roomList);
        System.out.println("chatRoom" + chatRoom);
        for( Long userKey : chatRoom.keySet()){

            if(!userKey.equals(userNumber)){
                session = chatRoom.get(userKey);
            }
        }
        System.out.println("getSession의값 " + session);
        return session;
    }

//    public Collection<WebSocketSession> getAllSessions() {
//        return sessions.values();
//    }

}
