package data.prime.newswidget.controller;

import data.prime.newswidget.model.News;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;


    public WebSocketEventListener(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    @Scheduled(fixedRate = 1000)
    public void handleWebSocketDisconnectListener() {

        News news = new News();
        news.setId(1L);
        news.setDate(new Date(123123213));
        news.setFamiliar(false);
        news.setText("ASDASDASD");
        news.setTopic("TEST_TEST");

        messagingTemplate.convertAndSend("/topic/public", news);
    }
}