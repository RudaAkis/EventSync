package ibm.event.sync.EventSync.dtos;

public class SentimentSummaryDTO {
    private SentimentValue sentiment;

    private Long count;

    public SentimentSummaryDTO() {
    }

    public SentimentSummaryDTO(SentimentValue sentiment, Long count) {
        this.sentiment = sentiment;
        this.count = count;
    }

    public SentimentValue getSentiment() {
        return sentiment;
    }

    public void setSentiment(SentimentValue sentiment) {
        this.sentiment = sentiment;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
