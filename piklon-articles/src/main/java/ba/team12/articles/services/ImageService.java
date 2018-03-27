package ba.team12.articles.services;

import ba.team12.articles.models.Image;
import ba.team12.articles.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> findBydata(byte[] data) { return imageRepository. findBydata( data);
    }
    public List<Image> findByIdi(Long id) { return imageRepository. findByIdi( id);
    }

    public void save( Image  image) {
        imageRepository.save(image);
    }
}
