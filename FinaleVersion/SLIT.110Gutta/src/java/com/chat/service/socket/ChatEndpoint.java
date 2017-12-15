package com.chat.service.socket;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.chat.model.ChatMessage;
import com.chat.model.Request;
import com.chat.service.*;


//mapping model-layer
@ServerEndpoint(value = "/chat")
public class ChatEndpoint {
        
	private Logger log = Logger.getLogger(ChatEndpoint.class.getSimpleName());
	private ChatRoom room = ChatRoom.getRoom();

        //Current session creating websocket, triggered when loggedinn (key-up)
	@OnOpen
	public void onOpen(final Session session, EndpointConfig config) {}
        //Text to JSON
	@OnMessage
	public void onMessage(final Session session, final String messageJson) {
		ObjectMapper mapper = new ObjectMapper(); //Converting/Serializing -> Bits to network to read
		ChatMessage chatMessage = null;
		try {
			chatMessage = mapper.readValue(messageJson, ChatMessage.class);
		} catch (IOException e) {
			String message = "Badly formatted message";
			try {
				session.close(new CloseReason(CloseReason.CloseCodes.CANNOT_ACCEPT, message));
			} catch (IOException ex) { log.severe(ex.getMessage()); }
		} ;

		Map<String, Object> properties = session.getUserProperties();
		if (chatMessage.getMessageType() == Request.LOGIN) {
			String name = chatMessage.getMessage();
			properties.put("name", name);
			room.join(session);
			room.sendMessage(name + " - Joined the chat room");
		}
		else {
			String name = (String)properties.get("name");
			room.sendMessage(name + " - " + chatMessage.getMessage());
                        
                        
                  
               
                    
                
                              
                  // out.print("hey student");
                    
                }
	}

	@OnClose
	public void OnClose(Session session, CloseReason reason) {
		room.leave(session);
		room.sendMessage((String)session.getUserProperties().get("name") + " - Left the room");
	}

	@OnError
	public void onError(Session session, Throwable ex) { log.info("Error: " + ex.getMessage()); }
}
