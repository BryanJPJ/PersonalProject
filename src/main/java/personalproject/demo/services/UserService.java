package personalproject.demo.services;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import personalproject.demo.models.ImageUser;
import personalproject.demo.models.User;
import personalproject.demo.repositories.ImageUserRepository;
import personalproject.demo.repositories.UserRepository;
import personalproject.demo.utils.FileUploadUtil;
import personalproject.demo.utils.RouteFileUploadImage;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    private ImageUserRepository imageUserRepository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User store(User user) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        return repository.save(user);
    }

    public ResponseEntity<Object> saveImageUser(MultipartFile multipartFile, Long id) throws IOException {
        ImageUser imageExist = listOneImage(id);
        if (imageExist != null) {
            deleteImageUser(id);
        }

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        ImageUser fileNameExist = imageUserRepository.findByImage(fileName);

        if (fileNameExist != null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        String uploadDir = RouteFileUploadImage.pathToSaveImage("imageUser");
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        ImageUser imageUserNew = new ImageUser();
        imageUserNew.setImage(fileName);
        imageUserRepository.save(imageUserNew);

        User userToAddImage = repository.findById(id).orElseThrow();
        userToAddImage.setImageUser(imageUserNew);
        repository.save(userToAddImage);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void deleteImageUser(Long iduser) throws IOException {
        User userToDeleteImage = repository.findById(iduser).orElseThrow();
        ImageUser imageToDelete = userToDeleteImage.getImageUser();
        userToDeleteImage.setImageUser(null);
        imageUserRepository.delete(imageToDelete);
        String uploadDir = RouteFileUploadImage.pathToSaveImage("imageUser");
        Path fileToDeletePath = Paths.get(uploadDir + imageToDelete.getImage());
        Files.delete(fileToDeletePath);
    }

    public List<User> listAll() {
        return repository.findAllByOrderByLastnameAsc();
    }

    public List<User> listAllPublic() {
        return repository.findAllByOrderByLastnameAsc();
    }

    public User listOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ImageUser listOneImage(Long id) {
        User userImage = repository.findById(id).orElseThrow(null);
        ImageUser imageUser = userImage.getImageUser();
        if (imageUser == null) {
            return null;
        }
        Long idImage = imageUser.getId();
        return imageUserRepository.findById(idImage).orElseThrow(null);
    }

    public User listOneByName(String userName) {
        return repository.findByUsername(userName).orElse(null);
    }

    public void delete(Long id) throws IOException {
        ImageUser imageExist = listOneImage(id);
        if (imageExist != null) {
            deleteImageUser(id);
        }
        repository.deleteById(id);
    }
}
