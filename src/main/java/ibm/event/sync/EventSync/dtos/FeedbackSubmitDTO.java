package ibm.event.sync.EventSync.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class FeedbackSubmitDTO {

    @NotBlank(message = "The feedback message cannot be empty")
    private String message;

    public FeedbackSubmitDTO() {
    }

    public FeedbackSubmitDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
