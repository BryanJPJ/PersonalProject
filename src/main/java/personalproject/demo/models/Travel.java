package personalproject.demo.models;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "travels")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_travel")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private java.time.LocalDate datetravel;
    @Column(nullable = false)
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_travel")
    private List<ImageTravel> imageTravel;

    public Travel(Long id, String name, LocalDate datetravel, String description, ImageTravel imagetravel) {
        this.id = id;
        this.name = name;
        this.datetravel = datetravel;
        this.description = description;

    }

    public Travel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.time.LocalDate getDatetravel() {
        return datetravel;
    }

    public void setDatetravel(java.time.LocalDate datetravel) {
        this.datetravel = datetravel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImageTravel> getImageTravel() {
        return imageTravel;
    }

    public void setImageTravel(List<ImageTravel> imageTravel) {
        this.imageTravel = imageTravel;
    }

}
