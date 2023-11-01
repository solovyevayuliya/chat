package ru.otus.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class AuthenticationFacade {
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public MyUserDetails getAuthUser(WebSocketSession session) {
        var token = (UsernamePasswordAuthenticationToken) session.getPrincipal();
        if (token == null) {
            return null;
        }
        return (MyUserDetails) token.getPrincipal();
    }
}
