package ibm.event.sync.EventSync.services;

import ibm.event.sync.EventSync.dtos.SentimentResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class SentimentService {

    private final RestClient restClient;

    public SentimentService(@Value("${huggingface.api.key}") String ApiKey){
        this.restClient = RestClient.builder()
                .baseUrl("https://api-inference.huggingface.co/models/cardiffnlp/twitter-roberta-base-sentiment")
                .defaultHeader(HttpHeaders.AUTHORIZATION, ApiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public SentimentResponseDTO[] analyzeSentiment(String message) {
        Map<String, String> requestBody = Map.of("inputs", message);

        //Wrapping the response in another array since the API returns [ [{},{},{}] ]
        SentimentResponseDTO[][] wrappedResponse = restClient
                .post()
                .body(requestBody)
                .retrieve()
                .body(SentimentResponseDTO[][].class);
        if(wrappedResponse == null){
            return  new SentimentResponseDTO[0];
        }
        return wrappedResponse[0];
    }

}
