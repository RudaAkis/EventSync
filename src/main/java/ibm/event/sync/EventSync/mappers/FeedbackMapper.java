package ibm.event.sync.EventSync.mappers;

import ibm.event.sync.EventSync.dtos.FeedbackDTO;
import ibm.event.sync.EventSync.entities.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {

    public Feedback toEntity(FeedbackDTO dto){
        return new Feedback(
                dto.getMessage(),
                dto.getDateTime(),
                dto.getEvent(),
                dto.getSentiment()
        );
    }

    public FeedbackDTO toDTO(Feedback entity){
        return new FeedbackDTO(
                entity.getId(),
                entity.getMessage(),
                entity.getDateTime(),
                entity.getEvent(),
                entity.getSentiment()
        );
    }
}
