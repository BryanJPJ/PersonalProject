package personalproject.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import personalproject.demo.models.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long> {
    List<Travel> findAllByOrderByDatetravelAsc();
}
