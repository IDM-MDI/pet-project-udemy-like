package pet.by.ishangulyev.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.by.ishangulyev.userservice.model.ContactInfoModel;
import pet.by.ishangulyev.userservice.model.PersonalInfoModel;
import pet.by.ishangulyev.userservice.model.UserAuthenticationModel;
import pet.by.ishangulyev.userservice.model.UserDescriptionModel;
import pet.by.ishangulyev.userservice.service.UserService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/user")
public class UserUpdateController {
    private final UserService service;

    @Autowired
    public UserUpdateController(UserService service) {
        this.service = service;
    }

    @PatchMapping("/{id}/auth")
    public ResponseEntity<String> updateUserAuthentication(@PathVariable("id") String id,
                                                           UserAuthenticationModel model) {
        service.update(id,model);
        return ok("Authentication was successfully updated");
    }
    @PatchMapping("/{id}/personal")
    public ResponseEntity<String> updateUserPersonalInfo(@PathVariable("id") String id,
                                                         PersonalInfoModel model) {
        service.update(id,model);
        return ok("Personal info was successfully updated");
    }
    @PatchMapping("/{id}/contact")
    public ResponseEntity<String> updateUserContactInfo(@PathVariable("id") String id,
                                                        ContactInfoModel model) {
        service.update(id,model);
        return ok("Contact info was successfully updated");
    }
    @PatchMapping("/{id}/description")
    public ResponseEntity<String> updateUserDescription(@PathVariable("id") String id,
                                                        UserDescriptionModel model) {
        service.update(id, model);
        return ok("Description was successfully updated");
    }
}
