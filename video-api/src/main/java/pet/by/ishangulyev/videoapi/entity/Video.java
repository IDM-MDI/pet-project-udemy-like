package pet.by.ishangulyev.videoapi.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Builder
@Data
@Document(collection = "videos")
public class Video {
    @Id
    private String id;
    private String name;
    @DocumentReference(collection = "videoFiles")
    private VideoFile videoFile;
    private long length;
    private double size;
    private LocalDateTime uploadDate;
}
