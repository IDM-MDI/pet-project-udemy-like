package pet.by.ishangulyev.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.by.ishangulyev.userservice.model.PersonalInfoModel;
import pet.by.ishangulyev.userservice.repository.PersonalInfoRepository;
import pet.by.ishangulyev.userservice.util.impl.PersonalInfoMapper;

@Service
public class PersonalInfoService {
    private final PersonalInfoRepository repository;
    private final PersonalInfoMapper mapper;

    @Autowired
    public PersonalInfoService(PersonalInfoRepository repository, PersonalInfoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void update(String id, PersonalInfoModel model) {
    }
}
