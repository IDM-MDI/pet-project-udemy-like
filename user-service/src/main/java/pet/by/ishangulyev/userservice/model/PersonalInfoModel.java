package pet.by.ishangulyev.userservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class PersonalInfoModel {
    private String name;
    private String surname;
    private String lastname;
    private Date date;
}
