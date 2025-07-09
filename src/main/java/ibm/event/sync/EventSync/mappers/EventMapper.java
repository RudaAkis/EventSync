package ibm.event.sync.EventSync.mappers;

import ibm.event.sync.EventSync.dtos.EventDTO;
import ibm.event.sync.EventSync.entities.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public Event toEntity(EventDTO dto){
        return new Event(
                dto.getName(),
                dto.getDescription()
        );
    }

    public EventDTO toDTO(Event entity){
        return new EventDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}
