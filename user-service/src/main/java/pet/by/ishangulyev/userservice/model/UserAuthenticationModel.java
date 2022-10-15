package pet.by.ishangulyev.userservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserAuthenticationModel {
    private String login;
    private String password;
}
