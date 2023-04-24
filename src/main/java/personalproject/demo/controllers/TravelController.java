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

// import com.baile.grupodebaile.models.Travel;
import personalproject.demo.models.*;
// import com.baile.grupodebaile.services.TravelService;
import personalproject.demo.services.*;;

@RestController
@RequestMapping(path = "/api")

public class TravelController {

    private TravelService service;

    public TravelController(TravelService service) {
        this.service = service;
    }

    @PostMapping(path = "/travels")
    public Travel store(@RequestBody Travel travel) {
        return service.save(travel);

    }

    @GetMapping("/travels")
    public List<Travel> listAll() {
        return service.listAll();
    }

    @GetMapping("/travels/{id}")
    public Travel listOne(@PathVariable Long id) {
        return service.listOne(id);
    }

    @DeleteMapping("/travels/{id}")
    public void delete(@PathVariable Long id) throws IOException {
        service.delete(id);
    }

    @PutMapping("/travels/{id}")
    public Travel update(@PathVariable Long id, @RequestBody Travel travelNew) {
        return service.update(id, travelNew);
    }

    @PostMapping("/travels/{id}/imagestravel")
    public void storeImageTravel(@RequestParam("image") MultipartFile multipartFile, @PathVariable Long id)
            throws IOException {
        service.saveImageTravel(multipartFile, id);
    }

    @DeleteMapping("/travels/{idtravel}/imagestravel/{idimage}")
    public void deleteImageTravel(@PathVariable Long idtravel, @PathVariable Long idimage)
            throws IOException {
        service.deleteImageTravel(idtravel, idimage);
    }


}