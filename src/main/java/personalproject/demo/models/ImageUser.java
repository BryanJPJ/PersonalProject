package personalproject.demo.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imageuser")
public class ImageUser {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_imageuser")
    private Long id;
    @Column(nullable = false)
    private String image;

    public ImageUser() {
    }

    public ImageUser(Long id, String image) {
        this.id = id;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }   
}