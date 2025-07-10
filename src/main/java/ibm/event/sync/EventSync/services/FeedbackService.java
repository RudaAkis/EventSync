package ibm.event.sync.EventSync.services;

import ibm.event.sync.EventSync.dtos.FeedbackDTO;
import ibm.event.sync.EventSync.dtos.FeedbackSubmitDTO;
import ibm.event.sync.EventSync.dtos.SentimentResponseDTO;
import ibm.event.sync.EventSync.dtos.SentimentValue;
import ibm.event.sync.EventSync.entities.Event;
import ibm.event.sync.EventSync.entities.Feedback;
import ibm.event.sync.EventSync.mappers.EventMapper;
import ibm.event.sync.EventSync.mappers.FeedbackMapper;
import ibm.event.sync.EventSync.repositories.EventRepository;
import ibm.event.sync.EventSync.repositories.FeedbackRepository;
import ibm.event.sync.EventSync.utilities.SentimentUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    private final SentimentService sentimentService;

    private final SentimentUtil sentimentUtil;

    private final EventRepository eventRepository;

    private final FeedbackMapper feedbackMapper;

    private final EventMapper eventMapper;

    public FeedbackService(FeedbackRepository feedbackRepository, SentimentService sentimentService,
                           SentimentUtil sentimentUtil, EventRepository eventRepository,
                           FeedbackMapper feedbackMapper, EventMapper eventMapper){
        this.feedbackRepository = feedbackRepository;
        this.sentimentService = sentimentService;
        this.sentimentUtil = sentimentUtil;
        this.eventRepository = eventRepository;
        this.feedbackMapper = feedbackMapper;
        this.eventMapper = eventMapper;
    }

    public FeedbackDTO submitFeedback(FeedbackSubmitDTO feedbackSubmitDTO, UUID eventId){
        SentimentResponseDTO [] sentimentResponseArray = sentimentService.analyzeSentiment(feedbackSubmitDTO.getMessage());

        SentimentValue sentimentValue =
                sentimentUtil.convertSentimentLabelToSentimentValue(sentimentUtil.maxSentimentValueResponse(sentimentResponseArray));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event was not found with ID: " + eventId));

        Feedback feedback = new Feedback();
        feedback.setMessage(feedbackSubmitDTO.getMessage());
        feedback.setEvent(event);
        feedback.setDateTime(LocalDateTime.now());
        feedback.setSentiment(sentimentValue);

        Feedback savedFeedback = feedbackRepository.save(feedback);

        return feedbackMapper.toDTO(savedFeedback, eventMapper.toDTO(event));
    }

}
