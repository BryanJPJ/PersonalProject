package personalproject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import personalproject.demo.models.ImageTravel;

public interface ImageTravelRepository extends JpaRepository<ImageTravel, Long> {
    
}
