package pet.by.ishangulyev.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pet.by.ishangulyev.userservice.entity.ContactInfo;

@Repository
public interface ContactInfoRepository extends MongoRepository<ContactInfo,String> {
}
