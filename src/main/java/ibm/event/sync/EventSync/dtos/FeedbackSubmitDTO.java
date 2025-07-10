package ibm.event.sync.EventSync.dtos;

public class FeedbackSubmitDTO {

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
