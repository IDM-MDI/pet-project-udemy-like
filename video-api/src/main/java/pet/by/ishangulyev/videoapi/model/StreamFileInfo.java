package pet.by.ishangulyev.videoapi.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Builder
@Data
public class StreamFileInfo {
    private final StreamingResponseBody responseBody;
    private long fileSize;
    private long contentLength;
    private long rangeStart;
    private long rangeEnd;
}
