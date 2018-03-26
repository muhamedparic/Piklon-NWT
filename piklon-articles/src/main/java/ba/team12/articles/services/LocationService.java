package ba.team12.articles.services;

import ba.team12.articles.models.Location;
import ba.team12.articles.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findByName(String name) {
        return locationRepository.findByName(name);
    }

    public void save(Location location) {
        locationRepository.save(location);
    }
}
