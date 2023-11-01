package ru.otus.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.service.ChatMessageService;
import ru.otus.model.ChatMessageEntity;

import java.util.List;

@RestController
@RequestMapping("/chat/")
public class ChatController {

    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping
    public List<ChatMessageEntity> getAll() {
        return chatMessageService.getAll();
    }
}
