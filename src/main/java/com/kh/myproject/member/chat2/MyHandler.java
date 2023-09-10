package com.kh.myproject.member.chat2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kh.myproject.member.chat2.model.ChatMessage;
import com.kh.myproject.member.chat2.service.ChatMessageService;
import com.kh.myproject.member.chat2.service.ChatRoomService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        log.info("연결완료");

        // 현재 소켓통신으로 넘어오는 url은 ws + userNumber의 형태를 가지고 있다.
        // 하지만 여기선 첫번째 통신과 두번째 통신으로 나누어져야하낟
        // 1번째 통신 : 현재 userNumber의 모든 채팅방을 가지고 온다.
        // 2번째 통신 : 불러온 모든 채팅방에 해당하는 소켓을 열어야 한다.

        //    /ws/roomId/userNumber

        String str = session.getUri().getPath().substring((session.getId().lastIndexOf("/")) + 5);
        Long roomId = Long.parseLong(str.split("/")[0]);
        Long userNumber = Long.parseLong(str.split("/")[1]);



        log.info("연결된 소켓의 RoomIㅇ는 {}",roomId);

        // 현재 소켓에 접속한 세션의 정보를 저장해야한다.
        sessionManager.addSession(roomId, userNumber, session);

        // 하나의 값만 유지하기 때문에 삭제는 따로 구현하지 않아도 되나?


        //n번 방의 n번 유저의 session을 추가한다.

    }


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {


        String type = "";  // 전송된 메시지의 타입.
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();
        //객체 파싱을 위한 매퍼
        ObjectMapper objectMapper = new ObjectMapper();

        // 객체 json 파싱을 위한 타임 모듈 추가.
        objectMapper.registerModule(new JavaTimeModule());


        String str = session.getUri().getPath().substring((session.getId().lastIndexOf("/")) + 5);
        System.out.println("str = " + str);

        // 메시지를 전송한 사람의 정보.
        Long roomId = Long.parseLong(str.split("/")[0]);
        Long userNumber = Long.parseLong(str.split("/")[1]);

        WebSocketSession yourSession = sessionManager.getSession(roomId, userNumber);
        // 나를 제외한 같은 방에 있는 유저의 세션을 얻어온다.


        try {

            type = (String) ((JSONObject) jsonParser.parse(message.getPayload())).get("type");

            if (type.equals("close")) { // 소켓 종료 알림시 세션 제거후 바로 메서드 종료.
                sessionManager.removeSession(roomId, userNumber);
                System.out.println("session remove 실행");
                return;
            }

            jsonObject = (JSONObject) jsonParser.parse(message.getPayload());


            // 수신된 메시지의 payload값을 읽어온다. 이를 통해 메시지를 db에저장하는 작업을 수행한다.

            // 받은 message를 파싱해서 데이터베이스에 저장하는 작업을 거친다.


            String content = (String) jsonObject.get("content");
            ChatMessage chatMessage = chatMessageService.saveMessage(roomId, userNumber, content);// 저장 한 후의 message content를 가지고 온다.

            //반환할때는 메시지에 대한 전체 내용이 담긴 chatMessage객체를 전달한다.

            String parseSendMessage = "";

            parseSendMessage = objectMapper.writeValueAsString(chatMessage);

            jsonObject.put("message", parseSendMessage);
            TextMessage sendMessage = new TextMessage(parseSendMessage);
            // 객체를 JSON타입의 문자열로 파싱하고 chatMessage객체 문자열을 송신한다.
            if (yourSession != null) {

                System.out.println("yoursession에 메시지를 전송한다.");
                yourSession.sendMessage(new TextMessage(jsonObject.toJSONString()));
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

        System.out.println("error");
        ;
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

        log.info("핸들러에의해 remove 메서드 실행(비정상적인 경로로 종료 / reoload, 페이지 종료 등");
        String str = session.getUri().getPath().substring((session.getId().lastIndexOf("/")) + 5);
        Long roomId = Long.parseLong(str.split("/")[0]);
        Long userNumber = Long.parseLong(str.split("/")[1]);
        sessionManager.removeSession(roomId, userNumber);

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


}

