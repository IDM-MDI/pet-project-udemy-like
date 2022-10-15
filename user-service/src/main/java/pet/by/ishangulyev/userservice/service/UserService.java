package pet.by.ishangulyev.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.by.ishangulyev.userservice.entity.User;
import pet.by.ishangulyev.userservice.exception.UserException;
import pet.by.ishangulyev.userservice.model.ContactInfoModel;
import pet.by.ishangulyev.userservice.model.PersonalInfoModel;
import pet.by.ishangulyev.userservice.model.UserAuthenticationModel;
import pet.by.ishangulyev.userservice.model.UserDescriptionModel;
import pet.by.ishangulyev.userservice.model.UserModel;
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

    public void update(String id, UserAuthenticationModel model) {
    }

    public void update(String id, PersonalInfoModel model) {
    }

    public void update(String id, ContactInfoModel model) {
    }

    public void update(String id, UserDescriptionModel model) {
    }

    public UserModel findUserModelByID(String id) {
        return null;
    }
}
