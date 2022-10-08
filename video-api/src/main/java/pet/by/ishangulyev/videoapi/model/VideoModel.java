package pet.by.ishangulyev.videoapi.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class VideoModel {
    private String id;
    private long videoFileID;
    private long length;
    private long size;
    private String name;
    private LocalDateTime uploadDate;
}
