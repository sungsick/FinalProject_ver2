package com.kh.myproject.member.chat2;

import com.kh.myproject.member.chat2.service.ChatMessageService;
import com.kh.myproject.member.chat2.service.ChatRoomService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    ChatMessageService chatMessageService;

    @Autowired
    WebChatController webChatController;

    @Autowired
    SessionManager sessionManager;



    // 소켓 연결이 완료됐을 때 실행되는 메서드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {


        // 채팅방 첫 접속이라면 userNumber만 붙어 있을 것이다.
        System.out.println("연결완료");

        // 현재 소켓통신으로 넘어오는 url은 ws + userNumber의 형태를 가지고 있다.
        // 하지만 여기선 첫번째 통신과 두번째 통신으로 나누어져야하낟
        // 1번째 통신 : 현재 userNumber의 모든 채팅방을 가지고 온다.
        // 2번째 통신 : 불러온 모든 채팅방에 해당하는 소켓을 열어야 한다.

        //    /ws/roomId/userNumber

        String str =session.getUri().getPath().substring((session.getId().lastIndexOf("/"))+5);
        System.out.println("str = "+ str);
        Long roomId = Long.parseLong(str.split("/")[0]);
        Long userNumber = Long.parseLong(str.split("/")[1]);

        System.out.println("roomId" + roomId);
        System.out.println("userNumber" + userNumber);

        System.out.println("연결된 소켓의 roomId 는" + roomId);


        // 현재 소켓에 접속한 세션의 정보를 저장해야한다.
        sessionManager.addSession(roomId,userNumber,session);

        // 하나의 값만 유지하기 때문에 삭제는 따로 구현하지 않아도 되나?


        //n번 방의 n번 유저의 session을 추가한다.

    }


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {

        // 특정 소켓이 send 메서드를 실행하면 실행되는 핸들러 메서드이다.
        // 이 메서드가 실행됐을 경우에는 특정 소켓의 session값을 가지고 있다.
        // 소켓이 열리는 즉시 해당 소켓의 세션 id를 보유하고 있는 객\\

        String str =session.getUri().getPath().substring((session.getId().lastIndexOf("/"))+5);
        System.out.println("str = "+ str);

        // 메시지를 전송한 사람의 정보.
        Long roomId = Long.parseLong(str.split("/")[0]);
        Long userNumber = Long.parseLong(str.split("/")[1]);

        WebSocketSession yourSession = sessionManager.getSession(roomId,userNumber);
        // 나를 제외한 같은 방에 있는 유저의 세션을 얻어온다.

        try {
            // 현재 상대방은 소켓에 접속해이씾 않은 상태일 수 있다. 따라서 yourSession은 null일 수 있다.
            // 접속해있지 않다면 그냥 db에만 저장하면 된다.
            if(yourSession!=null) {
                yourSession.sendMessage(message);
            }
            System.out.println("message의 payload값" + message.getPayload());
            JSONObject jsonObject = null;
            JSONParser jsonParser = new JSONParser();
            try {
                jsonObject = (JSONObject) jsonParser.parse(message.getPayload());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String content = (String) jsonObject.get("content");
            content = content.substring(0, content.length()-1);
            System.out.println(content);

            chatMessageService.saveMessage(roomId,userNumber,content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 메시지를 보냈을떄 해당 roomId를 가지고 있는 user에게 메시지를 보낸다. (본인제외)
//        for (String key : userList.keySet()) {
//
//            WebSocketSession wss = userList.get(key);
//            if (!session.getId().equals(wss.getId())) { // 메시지를 보낸 사람과 userList에 서로 다른 사람일때만 메시지를 보낸다.
//
//                try {
//                    wss.sendMessage(message); // 해당 세션으로 메시지를 보낸다.
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//        }

    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

        System.out.println("error");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

        // close 이벤트가 발생한다.여기서 close는 소켃 연결 종료를 뜻하고 채팅방을 나가는 것은 아니다.


        System.out.println("close");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
