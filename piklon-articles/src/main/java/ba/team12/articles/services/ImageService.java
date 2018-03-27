package ba.team12.articles.services;

import ba.team12.articles.models.Image;
import ba.team12.articles.models.Location;
import ba.team12.articles.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List < Image > findByData(byte[] data) {
        return imageRepository.findByData(data);
    }
    public List<Image> findAll() {
        return imageRepository.findAllByOrderById();
    }

    public void save(Image image) {
        imageRepository.save(image);
    }
}