package com.demo.mcp;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.mcp.runtime.McpToolBox;
import jakarta.enterprise.context.SessionScoped;

@SessionScoped
@RegisterAiService
public interface MultiToolService {
    @SystemMessage("""
        You are a helpful assistant capable of calling tools. 
        Use the provided MCP tools when appropriate.
        The tools to call are getWeather and getCurrentTimeinTimezone
        Do not answer directly - always call the appropriate method
        The returned temperatures must be in Celsius, if not convert it to Celsius
        For datetime question, return response in a full friendly English sentence
        
        The only formatting allowed is the following html tags: 
          b, strong, i, em, u, del, small, big, sup, sub, p, h1, h2, h3, h4, h5, h6, br, hr, ul, ol, li
        If there isn't a tool matched, return with an apology message
    """)
    @McpToolBox
    String chat(@UserMessage String message);

    
}
