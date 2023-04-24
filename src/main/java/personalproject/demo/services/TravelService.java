package personalproject.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;

import personalproject.demo.models.ImageTravel;
import personalproject.demo.repositories.ImageTravelRepository;
import personalproject.demo.utils.FileUploadUtil;
import personalproject.demo.utils.RouteFileUploadImage;

import personalproject.demo.models.Travel;
import personalproject.demo.repositories.TravelRepository;
@Service
public class TravelService {
    private TravelRepository repository;

    @Autowired
    private ImageTravelRepository imageTravelRepository;

    public TravelService(TravelRepository repository) {
        this.repository = repository;
    }

    public Travel save(Travel travelNew) {
        return repository.save(travelNew);
    }

    public List<Travel> listAll() {
        return repository.findAllByOrderByDatetravelAsc();
    }

    public Travel listOne(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    public void delete(Long id) throws IOException {
        Travel travelToDelete = listOne(id);
        List<ImageTravel> imagesActual = travelToDelete.getImageTravel();
        imagesActual.forEach(cosa -> {if(cosa.getId() ==4 ) cosa.getImage();});
        for (ImageTravel imageTravel : imagesActual) {
            String uploadDir = RouteFileUploadImage.pathToSaveImage("imageTravel");
            Path fileToDeletePath = Paths.get(uploadDir + imageTravel.getImage());
            Files.delete(fileToDeletePath);
        }
        repository.deleteById(id);
    }

    public Travel update(Long id, Travel travelNew) {
        Travel travelOld = listOne(id);
        List<ImageTravel> imagesOld = travelOld.getImageTravel();
        Travel travelToUpdate = travelNew;
        travelToUpdate.setId(id);
        travelToUpdate.setImageTravel(imagesOld);
        return repository.save(travelToUpdate);
    }

    public void saveImageTravel(MultipartFile multipartFile, Long id) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = RouteFileUploadImage.pathToSaveImage("imageTravel");
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        ImageTravel imageTravelNew = new ImageTravel();
        imageTravelNew.setImage(fileName);
        imageTravelRepository.save(imageTravelNew);

        Travel travelToAddImage = repository.findById(id).orElseThrow();
        List<ImageTravel> imageActualTravel = travelToAddImage.getImageTravel();
        imageActualTravel.add(imageTravelNew);
        travelToAddImage.setImageTravel(imageActualTravel);
        repository.save(travelToAddImage);
    }

    public void deleteImageTravel(Long idtravel, Long idimage) throws IOException {
        ImageTravel imageToDelete = imageTravelRepository.findById(idimage).orElseThrow(null);
        String imageDelete = imageToDelete.getImage();
        String uploadDir = RouteFileUploadImage.pathToSaveImage("imageTravel");
        Path fileToDeletePath = Paths.get(uploadDir + imageDelete);
        Files.delete(fileToDeletePath);

        Travel travelToDeleteImage = repository.findById(idtravel).orElseThrow(null);
        List<ImageTravel> imagesToTravel = travelToDeleteImage.getImageTravel();
        imagesToTravel.removeIf(image -> image.getId() == idimage);
        travelToDeleteImage.setImageTravel(imagesToTravel);
        repository.save(travelToDeleteImage);

        imageTravelRepository.deleteById(idimage);
    }
}
