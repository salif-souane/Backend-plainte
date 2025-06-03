package Salif.s.sa.Repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import Salif.s.sa.Entity.Sentiment;
import Salif.s.sa.Enums.TypeSentiments;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentiments type);
}
