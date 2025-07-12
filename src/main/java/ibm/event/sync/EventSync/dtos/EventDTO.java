package ibm.event.sync.EventSync.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class EventDTO {

    private UUID id;

    @NotBlank(message = "Event name cannot be empty")
    private String name;

    @NotBlank(message = "Event description cannot be empty")
    private String description;

    public EventDTO() {
    }

    public EventDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public EventDTO(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
