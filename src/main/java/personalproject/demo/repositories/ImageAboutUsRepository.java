package personalproject.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import personalproject.demo.models.ImageAboutUs;

public interface ImageAboutUsRepository extends JpaRepository <ImageAboutUs, Long> {
    public ImageAboutUs findByImage(String image);
}
