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

    public List<Location> search(String name) {
        return locationRepository.findByNameStartsWith(name);
    }

    public List<Location> findAll() {
        return locationRepository.findAllByOrderByName();
    }

    public Location findByExactName(String name) {
        List<Location> locations = locationRepository.findByName(name);

        if (locations.size() > 0)
            return locations.get(0);
        else
            return null;
    }

    public void save(Location location) {
        locationRepository.save(location);
    }
}
