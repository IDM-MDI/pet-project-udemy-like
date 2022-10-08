package pet.by.ishangulyev.videoapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoFileModel {
    private String id;
    private byte[] file;
}
