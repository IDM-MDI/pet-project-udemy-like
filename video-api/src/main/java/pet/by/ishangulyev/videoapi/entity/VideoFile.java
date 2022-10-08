package pet.by.ishangulyev.videoapi.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "videoFiles")
public class VideoFile {
    @Id
    private String id;
    private byte[] file;
}
