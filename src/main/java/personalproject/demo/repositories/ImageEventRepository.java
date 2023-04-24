package personalproject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import personalproject.demo.models.ImageEvent;

public interface ImageEventRepository extends JpaRepository<ImageEvent, Long> {
}
