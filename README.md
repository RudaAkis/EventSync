### Event Feedback Analyzer — a full-stack app for managing events, collecting user feedback, and analyzing sentiment using HuggingFace’s NLP API.


## Tech Stack
Backend: Java, Spring Boot, Hibernate, H2 (in-memory DB)

Frontend: React + Axios

Sentiment Analysis: HuggingFace API (RoBERTa-based model)

## Features:

Create & view events
Leave feedback for events
Auto-analyze sentiment (positive, neutral, negative)
View sentiment summaries
Form validation (frontend + backend)
Global exception handling
Sample data loaded on startup

# Running the Backend

## Prerequisites

JDK 17+
Maven
HuggingFace account + API token

### 1. Create .env File (in project root):
ini
Copy
Edit
HUGGINGFACE_API_KEY=your_token_here

### 2. Create application.properties in src/main/resources/:

spring.application.name=EventSync


spring.datasource.url=jdbc:h2:mem:eventsync
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=gvidas
spring.datasource.password=code

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.hibernate.ddl-auto=create
spring.jpa.generate-ddl=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

huggingface.api.key=${HUGGINGFACE_API_KEY}

# Run the App
bash
./mvnw spring-boot:run

## You’ll find:

### Endpoints

GET `/events`	List all events

GET	`/events/{id}` Get event by ID

POST `/events`	Create event

DELETE `/events/{id}`	Delete event

POST `/events/{eventId}/feedback`	Submit feedback for event

GET	`/events/{eventId}/summary` Get summary of sentiments

### Once the backend is running, Swagger UI is available at:

http://localhost:8080/swagger-ui/index.html

This provides:

Interactive documentation for all REST endpoints


H2 Console: http://localhost:8080/h2-console

Frontend

The React frontend is hosted in a separate repository:

Frontend Repository Link: (https://github.com/RudaAkis/EventSyncFrontend.git)

Running the Frontend

- Clone the frontend repo
- Run `npm install`
- Run `npm start`
- The frontend runs on `http://localhost:3000` and connects to this backend at `http://localhost:8080`
