package pet.by.ishangulyev.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pet.by.ishangulyev.userservice.entity.UserAuthentication;

@Repository
public interface UserAuthenticationRepository extends MongoRepository<UserAuthentication,String> {
    boolean existsByLogin(String login);
}
