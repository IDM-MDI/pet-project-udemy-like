package pet.by.ishangulyev.userservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "contactInfos")
public class ContactInfo {
    @Id
    private String id;
    private String email;
    private String phone;
}
