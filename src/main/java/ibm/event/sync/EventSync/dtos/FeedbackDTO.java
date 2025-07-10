package ibm.event.sync.EventSync.dtos;

import ibm.event.sync.EventSync.entities.Event;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import java.util.UUID;

public class FeedbackDTO {

    private UUID id;

    private String message;

    private LocalDateTime dateTime;

    private EventDTO eventDTO;

    @Enumerated(EnumType.STRING)
    private SentimentValue sentiment;

    public FeedbackDTO() {
    }

    public FeedbackDTO(String message,LocalDateTime dateTime, EventDTO eventDTO, SentimentValue sentiment) {
        this.message = message;
        this.eventDTO = eventDTO;
        this.sentiment = sentiment;
    }

    public FeedbackDTO(UUID id, String message,LocalDateTime dateTime, EventDTO eventDTO, SentimentValue sentiment) {
        this.id = id;
        this.message = message;
        this.eventDTO = eventDTO;
        this.sentiment = sentiment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }

    public SentimentValue getSentiment() {
        return sentiment;
    }

    public void setSentiment(SentimentValue sentiment) {
        this.sentiment = sentiment;
    }
}
