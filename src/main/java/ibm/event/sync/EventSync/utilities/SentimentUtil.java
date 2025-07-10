package ibm.event.sync.EventSync.utilities;

import ibm.event.sync.EventSync.dtos.LabelValue;
import ibm.event.sync.EventSync.dtos.SentimentResponseDTO;
import ibm.event.sync.EventSync.dtos.SentimentValue;
import org.springframework.stereotype.Component;

@Component
public class SentimentUtil {

    //Finding max value since API does not state results are always sorted even though as far as I tried they were
    public SentimentResponseDTO maxSentimentValueResponse(SentimentResponseDTO [] sentimentResponseArray){
        if (sentimentResponseArray == null || sentimentResponseArray.length == 0){
            throw new IllegalArgumentException("The sentiment response array is empty or null");
        }
        SentimentResponseDTO maxValueSentiment = sentimentResponseArray[0];
        for (int i = 1; i < sentimentResponseArray.length; i++){
            if (sentimentResponseArray[i].getScore() > maxValueSentiment.getScore()){
                maxValueSentiment = sentimentResponseArray[i];
            }
        }
        return maxValueSentiment;
    }

    public SentimentValue convertSentimentLabelToSentimentValue(SentimentResponseDTO sentimentResponseDTO){
        LabelValue label = LabelValue.valueOf(sentimentResponseDTO.getLabel());
        switch (label){
            case LabelValue.LABEL_0 -> {
                return SentimentValue.NEGATIVE;
            }
            case LabelValue.LABEL_1 -> {
                return SentimentValue.NEUTRAL;
            }
            case LabelValue.LABEL_2 -> {
                return SentimentValue.POSITIVE;
            }
            default -> throw new IllegalArgumentException("Unknown label: " + sentimentResponseDTO.getLabel());
        }
    }


}
