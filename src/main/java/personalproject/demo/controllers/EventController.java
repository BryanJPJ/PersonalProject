package personalproject.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import personalproject.demo.models.Event;
import personalproject.demo.services.EventService;

@RestController
@RequestMapping(path = "/api")

public class EventController {

    private EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping(path = "/events")
    public void store(@RequestBody Event event) {
        service.save(event);

    }

    @PostMapping("/events/{id}/imagesevent")
    public void storeImageEvent(@RequestParam("image") MultipartFile multipartFile, @PathVariable Long id)
            throws IOException {
        service.saveImageEvent(multipartFile, id);
    }

    @DeleteMapping("/events/{idevent}/imagesevent")
    public void deleteImageEvent(@PathVariable Long idevent) throws IOException {
        // service.deleteImageEvent(idevent);
    }

    @GetMapping("/events")
    public List<Event> listAll() {
        return service.listAll();
    }

    @GetMapping("/events/{id}")
    public Event listOne(@PathVariable Long id) {
        return service.listOne(id);
    }

    @DeleteMapping("/events/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/events/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event eventNew) {
        return service.update(id, eventNew);
    }
}