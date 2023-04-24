package personalproject.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import personalproject.demo.models.ImageUser;

public interface ImageUserRepository extends JpaRepository<ImageUser, Long>{
    public ImageUser findByImage(String image);

}