package personalproject.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import personalproject.demo.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByOrderByDateeventAsc();
}
