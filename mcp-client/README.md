# MCP Client (Quarkus)

This project provides a Quarkus-based MCP (Model Context Protocol) client application with an AI chatbot interface. The client connects to an MCP server running on Liberty to access weather forecast tools.

## Key Components

- `AiWeatherService`: Interface that defines the AI service with MCP tool integration
- `ChatBotWebSocket`: Handles WebSocket communication for the chat interface

## Prerequisites

- [Java 17+](https://developer.ibm.com/languages/java/semeru-runtimes/downloads/)
- [Ollama](https://ollama.com/download/) or [OpenAI API Key](https://platform.openai.com/account/api-keys) or [Anthropic API Key](https://docs.claude.com/en/docs/get-started)
- (Optional) Maven 3.8.1+ 
  - Alternatively use the provided Maven wrapper via `./mvnw` or `mvnw.cmd`

## Configuration

The application is configured in `application.properties`.  The connection to the MCP Server is configured using the following properties:

```properties
# MCP Server connection
quarkus.langchain4j.mcp.weather.transport-type=streamable-http
quarkus.langchain4j.mcp.weather.url=http://localhost:9080/mcp-liberty-server/mcp
```
### Model Options

**Ollama** can be used by commenting out lines from the `application.properties` file containing `openai` or `anthropic` and uncommenting lines containing `ollama`. This is the default configuration.

**OpenAI** can be used by commenting out lines from the `application.properties` file containing `ollama` or `anthropic` and uncommenting lines containing `openai`. You must also provide an OpenAI API Key by setting an `OPENAI_API_KEY` environment variable before running.

**Anthropic** can be used by commenting out lines from the `application.properties` file containing `ollama` or `openai` and uncommenting lines containing `anthropic`. You must also provide an Anthropic API Key by setting an `ANTHROPIC_API_KEY` environment variable before running.

## Running the Application

1. Start the Liberty MCP server (see mcp-liberty-server README)

2. Run the Quarkus application:
   ```bash
   ./mvnw quarkus:dev
   ```

3. Access the application at http://localhost:8080