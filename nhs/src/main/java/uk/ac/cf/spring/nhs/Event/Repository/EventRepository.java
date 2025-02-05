package uk.ac.cf.spring.nhs.Event.Repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.cf.spring.nhs.Event.Entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByUserId(Long userId, Sort date);

}