package pet.by.ishangulyev.userservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDescriptionModel {
    private String smallDescription;
    private String bigDescription;
}
