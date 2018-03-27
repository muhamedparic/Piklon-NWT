package ba.team12.articles.services;

import ba.team12.articles.models.ExtraInfo;
import ba.team12.articles.repositories.ExtraInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraInfoService {

    @Autowired
    private ExtraInfoRepository extraInfoRepository;

    public List < ExtraInfo > findByvalue(String value) {
        return extraInfoRepository.findByvalue(value);
    }

    public void save(ExtraInfo extraInfo) {
        extraInfoRepository.save(extraInfo);
    }
}