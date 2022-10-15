package pet.by.ishangulyev.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.by.ishangulyev.userservice.entity.User;
import pet.by.ishangulyev.userservice.exception.UserException;
import pet.by.ishangulyev.userservice.model.UserAuthenticationModel;
import pet.by.ishangulyev.userservice.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserAuthenticationService authenticationService;

    @Autowired
    public UserService(UserRepository repository, UserAuthenticationService authenticationService) {
        this.repository = repository;
        this.authenticationService = authenticationService;
    }
    public boolean isEntityExist(String id) {
        return repository.existsById(id);
    }
    public User save(UserAuthenticationModel authentication) throws UserException {
        return repository.save(
                User.builder()
                        .authentication(authenticationService.save(authentication))
                        .build());
    }
}
