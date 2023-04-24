package personalproject.demo.repositories;

import personalproject.demo.models.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutUsRepository extends JpaRepository<AboutUs, Long> {
    
}
