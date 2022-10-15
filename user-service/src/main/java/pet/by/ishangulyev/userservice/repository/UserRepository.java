package pet.by.ishangulyev.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pet.by.ishangulyev.userservice.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
