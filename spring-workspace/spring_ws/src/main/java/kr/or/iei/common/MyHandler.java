package kr.or.iei.common;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.javafx.scene.paint.GradientUtils.Parser;

@Component("myHandler")
public class MyHandler extends TextWebSocketHandler{
	
	/* 다이렉트 메세지 개수를 띄우려면 DB연결을 해야한다.
	@Autowired private DirectMessageDao dmDao;
	 */
	
	private ArrayList<WebSocketSession> members;
	private HashMap<String, WebSocketSession> map;
	public MyHandler() {
		members = new ArrayList<WebSocketSession>();
		map = new HashMap<String, WebSocketSession>();	//세션만 갖고 사용자를 구분할 수 없으니 맵의 키값으로 구분한다.
		
	}
	//소켓이 생성되어 연결되었을 때 동작되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결 성공 ! !");
		members.add(session); //신규 접속자 정보 저장
		//사용자의 아이디를 받음
		//사용자의 안 읽은 메세지 개수를 봄
		//그리고 그걸 헤더에 띄움
		
		
	}
	//메세지를 수신하면 동작하는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		//소켓으로 받은 메세지를 json 타입으로 변경하여 사용
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(message.getPayload());
		String type = element.getAsJsonObject().get("type").getAsString();
		if(type.equals("register")) {
			//type : register
			String memberId = element.getAsJsonObject().get("memberId").getAsString();
			map.put(memberId, session);
		}else {
			//type : chat
			String target = element.getAsJsonObject().get("target").getAsString();
			String msg = element.getAsJsonObject().get("msg").getAsString();
			WebSocketSession ws = map.get(target); //target key 값을 요청
			if(ws != null) {
				//해당 target이 없다면.
				ws.sendMessage(new TextMessage(msg));
			}
		}
		
	}
	//연결이 끊기면 동작하는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 종료 ! !");
		members.remove(session);
	}
}
