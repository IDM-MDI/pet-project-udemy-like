package pet.by.ishangulyev.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.by.ishangulyev.userservice.model.ContactInfoModel;
import pet.by.ishangulyev.userservice.repository.ContactInfoRepository;
import pet.by.ishangulyev.userservice.util.impl.ContactInfoMapper;

@Service
public class ContactInfoService {
    private final ContactInfoRepository repository;
    private final ContactInfoMapper mapper;

    @Autowired
    public ContactInfoService(ContactInfoRepository repository, ContactInfoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void update(String id, ContactInfoModel model) {

    }
}
