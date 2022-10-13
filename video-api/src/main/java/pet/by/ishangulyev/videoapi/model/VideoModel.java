package pet.by.ishangulyev.videoapi.model;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class VideoModel {
    private String id;
    private long length;
    private double size;
    private String name;
    private String videoFileID;
}
