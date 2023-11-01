package ru.otus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.model.ChatMessageEntity;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {
}
