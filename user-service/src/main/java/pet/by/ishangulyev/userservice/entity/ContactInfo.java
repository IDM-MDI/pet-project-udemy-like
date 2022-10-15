package pet.by.ishangulyev.userservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "contactInfos")
public class ContactInfo {
    @Id
    private String id;
    @Indexed(unique=true)
    private String email;
    @Indexed(unique=true)
    private String phone;
}
