package ibm.event.sync.EventSync.entities;

import ibm.event.sync.EventSync.dtos.SentimentValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String message;

    private LocalDateTime dateTime;

    private Event event;

    private SentimentValue sentiment;

    public Feedback() {
    }

    public Feedback(String message, LocalDateTime dateTime, Event event, SentimentValue sentiment) {
        this.message = message;
        this.dateTime = dateTime;
        this.event = event;
        this.sentiment = sentiment;
    }

    public Feedback(UUID id, String message, LocalDateTime dateTime, Event event, SentimentValue sentiment) {
        this.id = id;
        this.message = message;
        this.dateTime = dateTime;
        this.event = event;
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public SentimentValue getSentiment() {
        return sentiment;
    }

    public void setSentiment(SentimentValue sentiment) {
        this.sentiment = sentiment;
    }
}
