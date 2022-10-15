package pet.by.ishangulyev.userservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "descriptions")
public class UserDescription {
    @Id
    private String id;

    private String smallDescription;
    private String bigDescription;
}
