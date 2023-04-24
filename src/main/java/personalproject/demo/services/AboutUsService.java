package personalproject.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import personalproject.demo.models.AboutUs;
import personalproject.demo.models.ImageAboutUs;
import personalproject.demo.repositories.AboutUsRepository;
import personalproject.demo.repositories.ImageAboutUsRepository;
import personalproject.demo.utils.FileUploadUtil;
import personalproject.demo.utils.RouteFileUploadImage;

@Service
public class AboutUsService {
    private AboutUsRepository repository;

    @Autowired
    private ImageAboutUsRepository imageAboutUsRepository;

    public AboutUsService(AboutUsRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Object> saveImageAboutUs(MultipartFile multipartFile, Long id) throws IOException {
        ImageAboutUs imageExist = listOneImage(id);
        if (imageExist != null) {
            deleteImageAboutUs(id);
        }

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        ImageAboutUs fileNameExist = imageAboutUsRepository.findByImage(fileName);

        if (fileNameExist != null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        String uploadDir = RouteFileUploadImage.pathToSaveImage("imageAboutUs");
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        ImageAboutUs imageAboutUsNew = new ImageAboutUs();
        imageAboutUsNew.setImage(fileName);
        imageAboutUsRepository.save(imageAboutUsNew);

        AboutUs aboutUsToAddImage = repository.findById(id).orElseThrow();
        aboutUsToAddImage.setImageAboutUs(imageAboutUsNew);
        repository.save(aboutUsToAddImage);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public AboutUs save(AboutUs aboutUsNew) {
        return repository.save(aboutUsNew);
    }

    public List<AboutUs> listAll() {
        return repository.findAll();
    }

    public AboutUs listOne(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    public void delete(Long id) throws IOException {
        ImageAboutUs imageExist = listOneImage(id);
        if (imageExist != null) {
            deleteImageAboutUs(id);
        }
        repository.deleteById(id);
    }

    public AboutUs update(Long id, AboutUs aboutUsNew) {
        AboutUs aboutUsToUpdate = aboutUsNew;
        aboutUsToUpdate.setId(id);
        return repository.save(aboutUsToUpdate);
    }

    public void deleteImageAboutUs(Long idaboutus) throws IOException {
        AboutUs aboutUsToDeleteImage = repository.findById(idaboutus).orElseThrow(null);
        ImageAboutUs imageToDelete = aboutUsToDeleteImage.getImageAboutUs();
        aboutUsToDeleteImage.setImageAboutUs(null);
        imageAboutUsRepository.delete(imageToDelete);
        String uploadDir = RouteFileUploadImage.pathToSaveImage("imageAboutUs");
        Path fileToDeletePath = Paths.get(uploadDir + imageToDelete.getImage());
        Files.delete(fileToDeletePath);
    }

    public ImageAboutUs listOneImage(Long id) {
        AboutUs aboutUsImage = repository.findById(id).orElseThrow(null);
        ImageAboutUs imageaboutUs = aboutUsImage.getImageAboutUs();
        if (imageaboutUs == null) {
            return null;
        }
        Long idImage = imageaboutUs.getId();
        return imageAboutUsRepository.findById(idImage).orElseThrow(null);
    }

}
