package ibm.event.sync.EventSync.repositories;

import ibm.event.sync.EventSync.dtos.SentimentSummaryDTO;
import ibm.event.sync.EventSync.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {

    @Query("""
           Select new ibm.event.sync.EventSync.dtos.SentimentSummaryDTO (f.sentiment, COUNT(f)) 
           FROM Feedback f 
           WHERE f.event.id = :eventId 
           GROUP BY f.sentiment""")
    List<SentimentSummaryDTO> getSentimentSummaryByEvent(@Param("eventId") UUID eventId);
}
