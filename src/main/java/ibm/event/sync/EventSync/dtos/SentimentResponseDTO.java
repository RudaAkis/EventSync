package ibm.event.sync.EventSync.dtos;

public class SentimentResponseDTO {

    private String label;

    private Double score;

    public SentimentResponseDTO() {
    }

    public SentimentResponseDTO(String label, Double score) {
        this.label = label;
        this.score = score;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
