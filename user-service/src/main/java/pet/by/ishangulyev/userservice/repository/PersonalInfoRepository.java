package pet.by.ishangulyev.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pet.by.ishangulyev.userservice.entity.PersonalInfo;

@Repository
public interface PersonalInfoRepository extends MongoRepository<PersonalInfo,String> {
}
