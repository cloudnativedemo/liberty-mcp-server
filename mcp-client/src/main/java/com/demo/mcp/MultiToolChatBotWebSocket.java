package com.demo.mcp;
import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@WebSocket(path = "/mtchatbot")
@ApplicationScoped
public class MultiToolChatBotWebSocket {

    @Inject
    MultiToolService mtService;

    @OnOpen
    public String onOpen() {
        return "Hello, I am the Liberty MCP Server Weather Assistant, how can I help?";
    }

    @OnTextMessage
    @Blocking
    public String onMessage(String message) {
        return mtService.chat(message);
    }
    
}
