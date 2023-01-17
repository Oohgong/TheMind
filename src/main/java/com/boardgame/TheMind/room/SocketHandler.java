package com.boardgame.TheMind.room;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SocketHandler extends TextWebSocketHandler{

	//웹소켓 세션 담아둘 맵
	HashMap<String, WebSocketSession> sm = new HashMap<>();

	//접속했을 때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		// ws://localhost:81/gameRoom/숫자 <- 숫자만 가져오기
		String uri = session.getUri().toString();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		String msg = "{\"type\":\"connect\",\"roomNum\":\""+uri+"\"}";
		sm.put(session.getId(), session);
		
		for (String key : sm.keySet()) {
			WebSocketSession wss = sm.get(key);
			
			try {
				wss.sendMessage(new TextMessage(msg));
				log.info("&&&&&&&&&&&&&& after : "+msg);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//접속 끊긴 뒤
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String uri = session.getUri().toString();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		String msg = "{\"type\":\"disconnect\",\"roomNum\":\""+uri+"\"}";
		sm.remove(session.getId());
		
		for (String key : sm.keySet()) {
			WebSocketSession wss = sm.get(key);
			
			try {
				wss.sendMessage(new TextMessage(msg));
				log.info("&&&&&&&&&&&&&& after : "+msg);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//메세지 발송
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();
		
		for(String key : sm.keySet()) {
			WebSocketSession wss = sm.get(key);
			
			try {
				log.info("handler - msg : "+msg);
				wss.sendMessage(new TextMessage(msg));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	
}
