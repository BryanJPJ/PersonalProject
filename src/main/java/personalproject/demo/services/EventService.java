package personalproject.demo.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import personalproject.demo.models.Event;
import personalproject.demo.models.ImageEvent;
import personalproject.demo.repositories.EventRepository;
import personalproject.demo.repositories.ImageEventRepository;
import personalproject.demo.utils.FileUploadUtil;
import personalproject.demo.utils.RouteFileUploadImage;

@Service
public class EventService {
    private EventRepository repository;

    @Autowired
    private ImageEventRepository imageEventRepository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public void saveImageEvent(MultipartFile multipartFile, Long id) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = RouteFileUploadImage.pathToSaveImage("imageEvent");
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        ImageEvent imageEventNew = new ImageEvent();
        imageEventNew.setImage(fileName);
        imageEventRepository.save(imageEventNew);

        Event eventToAddImage = repository.findById(id).orElseThrow();
        eventToAddImage.setImageevent(imageEventNew);
        repository.save(eventToAddImage);
    }

    public void save(Event eventNew) {
        repository.save(eventNew);
    }

    public List<Event> listAll() {
        return repository.findAllByOrderByDateeventAsc();
    }

    public Event listOne(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Event update(Long id, Event eventNew) {
        Event eventToUpdate = eventNew;
        eventToUpdate.setId(id);
        return repository.save(eventToUpdate);
    }


}
