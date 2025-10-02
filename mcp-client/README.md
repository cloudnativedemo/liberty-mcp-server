# MCP Client (Quarkus)

This project provides a Quarkus-based MCP (Model Context Protocol) client application with an AI chatbot interface. The client connects to an MCP server running on Liberty to access weather forecast tools.

## Key Components

- `AiWeatherService`: Interface that defines the AI service with MCP tool integration
- `ChatBotWebSocket`: Handles WebSocket communication for the chat interface

## Configuration

The application is configured in `application.properties`.  The connection to the MCP Server is configured using the following properties:

```properties
# MCP Server connection
quarkus.langchain4j.mcp.weather.transport-type=streamable-http
quarkus.langchain4j.mcp.weather.url=http://localhost:9080/mcp-liberty-server/mcp
```
By default, Ollama is used as the LLM (Large Language Model) provider, with the `gpt-oss:20b` model. Alternatively, OpenAI can be used by setting the `quarkus.langchain4j.chat-model.provider` property to `openai` and providing an OpenAI API Key via `quarkus.langchain4j.openai.api-key`.
```properties
# LLM Provider Configuration
# quarkus.langchain4j.chat-model.provider=ollama
quarkus.langchain4j.chat-model.provider=openai

# OpenAI settings
quarkus.langchain4j.openai.api-key=${OPENAI_API_KEY}
quarkus.langchain4j.openai.chat-model.model-name=gpt-5-mini
```

## Prerequisites

- [Java 17+](https://developer.ibm.com/languages/java/semeru-runtimes/downloads/)
- [Ollama](https://ollama.com/download/) or [OpenAI API Key](https://platform.openai.com/account/api-keys)
- (Optional) Maven 3.8.1+ 
  - Alternatively use the provided Maven wrapper via `./mvnw` or `mvnw.cmd`

## Running the Application

1. Start the Liberty MCP server (see mcp-liberty-server README)

2. Run the Quarkus application:
   ```bash
   ./mvnw quarkus:dev
   ```

3. Access the application at http://localhost:8080