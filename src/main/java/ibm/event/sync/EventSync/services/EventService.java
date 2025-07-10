package ibm.event.sync.EventSync.services;

import ibm.event.sync.EventSync.dtos.EventDTO;
import ibm.event.sync.EventSync.dtos.SentimentResponseDTO;
import ibm.event.sync.EventSync.entities.Event;
import ibm.event.sync.EventSync.mappers.EventMapper;
import ibm.event.sync.EventSync.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper){
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public List<EventDTO> getAllEvents(){
        return eventRepository.findAll().stream().map( eventMapper::toDTO ).toList();
    }

    public EventDTO getEventById(UUID id){
        Event event = eventRepository.findById(id).orElseThrow( () -> new RuntimeException("Event not found with id: " + id));
        return eventMapper.toDTO(event);
    }

    public EventDTO create(EventDTO requestDTO){
        Event event = eventMapper.toEntity(requestDTO);
        Event savedEvent = eventRepository.save(event);

        return eventMapper.toDTO(savedEvent);
    }

    public boolean delete(UUID id){
        if (!eventRepository.existsById(id)){
            return false;
        }
        eventRepository.deleteById(id);
        return true;
    }
}
