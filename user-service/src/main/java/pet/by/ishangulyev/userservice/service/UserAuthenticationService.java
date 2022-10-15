package pet.by.ishangulyev.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.by.ishangulyev.userservice.entity.User;
import pet.by.ishangulyev.userservice.entity.UserAuthentication;
import pet.by.ishangulyev.userservice.exception.UserException;
import pet.by.ishangulyev.userservice.model.UserAuthenticationModel;
import pet.by.ishangulyev.userservice.repository.UserAuthenticationRepository;
import pet.by.ishangulyev.userservice.util.impl.AuthenticationMapper;
import pet.by.ishangulyev.userservice.validator.UserValidator;

import static pet.by.ishangulyev.userservice.exception.UserExceptionCode.USER_ALREADY_EXIST;
import static pet.by.ishangulyev.userservice.exception.UserExceptionCode.USER_NOT_VALID;
import static pet.by.ishangulyev.userservice.validator.AuthenticationValidator.isAuthenticationValid;

@Service
public class UserAuthenticationService {
    private final UserAuthenticationRepository repository;
    private final AuthenticationMapper mapper;

    @Autowired
    public UserAuthenticationService(UserAuthenticationRepository repository, AuthenticationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void update(String id, UserAuthenticationModel model) {
    }
    public boolean isEntityExistByID(String id) {
        return repository.existsById(id);
    }

    public boolean isEntityExistByLogin(String login) {
        return repository.existsByLogin(login);
    }
    public UserAuthentication save(UserAuthenticationModel authentication) throws UserException {
        authVerificationDuringRegistration(authentication);
        return repository.save(mapper.toEntity(authentication));
    }

    private void authVerificationDuringRegistration(UserAuthenticationModel authentication) throws UserException {
        if(!isAuthenticationValid(authentication)) {
            throw new UserException(USER_NOT_VALID.toString());
        }
        if(isEntityExistByLogin(authentication.getLogin())) {
            throw new UserException(USER_ALREADY_EXIST.toString());
        }
    }
}
