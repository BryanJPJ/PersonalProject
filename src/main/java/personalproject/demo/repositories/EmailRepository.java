package personalproject.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import personalproject.demo.models.EmailMessage;

public interface EmailRepository extends JpaRepository<EmailMessage, Long>{
    
}
