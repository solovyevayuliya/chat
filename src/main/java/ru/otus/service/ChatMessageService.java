package ru.otus.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.model.ChatMessageEntity;
import ru.otus.repository.ChatMessageRepository;

import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    ObjectMapper mapper;

    public String save(String username, String text) throws JsonProcessingException {
        ChatMessageEntity chatMessage = new ChatMessageEntity();
        chatMessage.setText(text);
        chatMessage.setUsername(username);
        var message = chatMessageRepository.save(chatMessage);
        return mapper.writeValueAsString(message);
    }

    public List<ChatMessageEntity> getAll() {
        return chatMessageRepository.findAll();
    }
}
