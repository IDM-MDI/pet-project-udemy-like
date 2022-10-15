package pet.by.ishangulyev.userservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String name;
}
