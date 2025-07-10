package ibm.event.sync.EventSync.mappers;

import ibm.event.sync.EventSync.dtos.EventDTO;
import ibm.event.sync.EventSync.dtos.FeedbackDTO;
import ibm.event.sync.EventSync.entities.Event;
import ibm.event.sync.EventSync.entities.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {

    public Feedback toEntity(FeedbackDTO dto, Event event){
        return new Feedback(
                dto.getMessage(),
                dto.getDateTime(),
                event,
                dto.getSentiment()
        );
    }

    public FeedbackDTO toDTO(Feedback entity, EventDTO eventDTO){
        return new FeedbackDTO(
                entity.getId(),
                entity.getMessage(),
                entity.getDateTime(),
                eventDTO,
                entity.getSentiment()
        );
    }
}
