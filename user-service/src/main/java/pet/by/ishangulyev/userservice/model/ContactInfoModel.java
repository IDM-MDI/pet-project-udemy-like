package pet.by.ishangulyev.userservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContactInfoModel {
    private String email;
    private String phone;
}
