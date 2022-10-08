package pet.by.ishangulyev.videoapi.controller;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import pet.by.ishangulyev.videoapi.model.StreamFileInfo;
import pet.by.ishangulyev.videoapi.service.VideoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/video")
@Log4j2
public class VideoController {

    private final VideoService service;

    @Autowired
    public VideoController(VideoService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StreamingResponseBody> getVideoFileByID(@PathVariable("id") String id,
                                                                  @RequestHeader("Range") String range) {
        StreamFileInfo videoFileByID = service.getVideoFileByID(id,range);
        log.log(Level.ALL,videoFileByID.toString());
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .header("Content-Type", "video/mp4")
                .header("Accept-Ranges", "bytes")
                .header("Content-Length", Long.toString(videoFileByID.getContentLength()))
                .header("Content-Range", "bytes " + videoFileByID.getRangeStart() + "-" +
                        videoFileByID.getRangeEnd() + "/" + videoFileByID.getFileSize())
                .body(videoFileByID.getResponseBody());
    }
    @SneakyThrows
    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveVideo(@RequestParam("file") MultipartFile file) {
        service.saveVideo(file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}