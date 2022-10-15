package pet.by.ishangulyev.userservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Builder
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @DocumentReference(collection = "authentications")
    private UserAuthentication authentication;
    @DocumentReference(collection = "descriptions")
    private UserDescription description;
    @DocumentReference(collection = "contactInfos")
    private ContactInfo contactInfo;
    @DocumentReference(collection = "personalInfos")
    private PersonalInfo personalInfo;
    @DocumentReference(collection = "roles")
    private List<Role> roles;
}
