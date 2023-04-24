package personalproject.demo.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import personalproject.demo.models.AboutUs;
import personalproject.demo.models.ImageAboutUs;
import personalproject.demo.services.AboutUsService;



@RestController
@RequestMapping(path = "/api")

public class AboutUsController {

    private AboutUsService service;

    public AboutUsController(AboutUsService service) {
        this.service = service;
    }

    @PostMapping(path = "/aboutus")
    public AboutUs store(@RequestBody AboutUs aboutUs) {
        return service.save(aboutUs);
    }

    @GetMapping("/aboutus")
    public List<AboutUs> listAll() {
        return service.listAll();
    }

    @GetMapping("/aboutus/{id}")
    public AboutUs listOne(@PathVariable Long id) {
        return service.listOne(id);
    }

    @DeleteMapping("/aboutus/{id}")
    public void delete(@PathVariable Long id) throws IOException {
        service.delete(id);
    }

    @PutMapping("/aboutus/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id, @RequestBody AboutUs aboutus) {
        try {
            ImageAboutUs imageActual = service.listOneImage(id);
            aboutus.setId(id);
            aboutus.setImageAboutUs(imageActual);
            AboutUs aboutUsDB = service.save(aboutus);
            String idNew = aboutUsDB.getId() + "";

            Map<String, String> json = new HashMap<>();
            json.put("id", idNew);
            json.put("name", aboutUsDB.getName());
            json.put("description", aboutUsDB.getDescription());
            json.put("message", "successful sign up");
            return ResponseEntity.status(HttpStatus.OK).body(json);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/aboutus/{id}/imagesaboutus")
    public ResponseEntity<Object> saveImageAboutUs(@RequestParam("image") MultipartFile multipartFile,
            @PathVariable Long id) throws IOException {
        return service.saveImageAboutUs(multipartFile, id);
    }

    @DeleteMapping("/aboutus/{id}/imagesaboutus")
    public void deleteImageAboutUs(@PathVariable Long id) throws IOException {
        service.deleteImageAboutUs(id);
    }

}