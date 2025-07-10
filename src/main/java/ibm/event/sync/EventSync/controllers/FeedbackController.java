package ibm.event.sync.EventSync.controllers;

import ibm.event.sync.EventSync.dtos.FeedbackDTO;
import ibm.event.sync.EventSync.dtos.FeedbackSubmitDTO;
import ibm.event.sync.EventSync.services.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/event")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }

    @PostMapping("/events/{eventId}/feedback")
    public ResponseEntity<FeedbackDTO> submitFeedback(@RequestBody FeedbackSubmitDTO feedbackSubmitDTO, @PathVariable UUID eventId){
        return new ResponseEntity<>(feedbackService.submitFeedback(feedbackSubmitDTO, eventId),HttpStatus.CREATED);
    }
}
