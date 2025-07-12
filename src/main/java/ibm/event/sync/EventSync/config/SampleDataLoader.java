package ibm.event.sync.EventSync.config;

import ibm.event.sync.EventSync.dtos.SentimentValue;
import ibm.event.sync.EventSync.entities.Event;
import ibm.event.sync.EventSync.entities.Feedback;
import ibm.event.sync.EventSync.repositories.EventRepository;
import ibm.event.sync.EventSync.repositories.FeedbackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class SampleDataLoader {

    @Bean
    public CommandLineRunner loadData(EventRepository eventRepository, FeedbackRepository feedbackRepository) {
        return args -> {
            // Create events
            Event event1 = new Event();
            event1.setName("Tech Talk");
            event1.setDescription("A deep dive into modern coding practices.");
            Event savedEvent1 = eventRepository.save(event1);

            Event event2 = new Event();
            event2.setName("AI Hackathon 2025");
            event2.setDescription("Compete to build the smartest AI.");
            Event savedEvent2 = eventRepository.save(event2);

            // Create feedback
            Feedback f1 = new Feedback();
            f1.setEvent(savedEvent1);
            f1.setMessage("Great event with a lot of insights!");
            f1.setDateTime(LocalDateTime.now().minusDays(1));
            f1.setSentiment(SentimentValue.POSITIVE);

            Feedback f2 = new Feedback();
            f2.setEvent(savedEvent1);
            f2.setMessage("Bit too fast-paced.");
            f2.setDateTime(LocalDateTime.now().minusHours(12));
            f2.setSentiment(SentimentValue.NEUTRAL);

            Feedback f3 = new Feedback();
            f3.setEvent(savedEvent2);
            f3.setMessage("Very disorganized, I couldn’t follow anything.");
            f3.setDateTime(LocalDateTime.now().minusHours(3));
            f3.setSentiment(SentimentValue.NEGATIVE);

            feedbackRepository.save(f1);
            feedbackRepository.save(f2);
            feedbackRepository.save(f3);
        };
    }
}

