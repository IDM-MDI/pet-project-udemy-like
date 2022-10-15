package pet.by.ishangulyev.userservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Builder
@Data
@Document(collection = "personalInfos")
public class PersonalInfo {
    @Id
    private String id;
    private String name;
    private String surname;
    private String lastname;
    private Date date;
}
