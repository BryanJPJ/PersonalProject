package personalproject.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private java.time.LocalDate dateevent;
    @Column(nullable = false)
    private String description;

    @OneToOne
    private ImageEvent imageevent;

    public Event(Long id, String name, LocalDate dateevent, String description, ImageEvent imageevent) {
        this.id = id;
        this.name = name;
        this.dateevent = dateevent;
        this.description = description;

    }

    public Event() {
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

    public java.time.LocalDate getDateevent() {
        return dateevent;
    }

    public void setDateevent(java.time.LocalDate dateevent) {
        this.dateevent = dateevent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageEvent getImageevent() {
        return imageevent;
    }

    public void setImageevent(ImageEvent imageevent) {
        this.imageevent = imageevent;
    }

}
