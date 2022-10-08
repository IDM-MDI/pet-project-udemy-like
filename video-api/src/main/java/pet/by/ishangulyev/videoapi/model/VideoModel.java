package pet.by.ishangulyev.videoapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class VideoModel {
    private String id;
    private long length;
    private long size;
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private byte[] file;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String videoFileID;
    private LocalDateTime uploadDate;
}
