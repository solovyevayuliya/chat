package ru.otus.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.otus.auth.AuthenticationFacade;
import ru.otus.service.ChatMessageService;

import java.util.HashSet;
import java.util.Set;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private AuthenticationFacade authenticationFacade;
    @Autowired
    private ChatMessageService chatMessageService;

    private static final Set<WebSocketSession> sessions = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String username = authenticationFacade.getAuthUser(session).getUsername();
        String payload = message.getPayload();
        String entity = chatMessageService.save(username, payload);
        for (WebSocketSession s : sessions) {
            s.sendMessage(new TextMessage(entity));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }
}
