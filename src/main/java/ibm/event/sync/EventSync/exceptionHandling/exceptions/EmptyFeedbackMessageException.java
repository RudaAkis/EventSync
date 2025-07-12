package ibm.event.sync.EventSync.exceptionHandling.exceptions;

import org.springframework.http.HttpStatus;

public class EmptyFeedbackMessageException extends BaseException{
    public EmptyFeedbackMessageException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
