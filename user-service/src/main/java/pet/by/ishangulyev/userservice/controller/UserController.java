package pet.by.ishangulyev.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.by.ishangulyev.userservice.exception.UserException;
import pet.by.ishangulyev.userservice.model.UserAuthenticationModel;
import pet.by.ishangulyev.userservice.model.UserModel;
import pet.by.ishangulyev.userservice.service.UserService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public UserModel getUserByID(@PathVariable String id) {
        return service.findUserModelByID(id);
    }
    @PostMapping
    public ResponseEntity<String> saveUser(UserAuthenticationModel model) throws UserException {
        service.save(model);
        return ok("User was successfully added");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        return ok("User was successfully deleted");
    }

}
