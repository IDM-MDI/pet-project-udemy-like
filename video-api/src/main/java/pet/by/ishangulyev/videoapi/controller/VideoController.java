package pet.by.ishangulyev.videoapi.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
import pet.by.ishangulyev.videoapi.service.VideoFileService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/video")
@Log4j2
public class VideoController {

    private final VideoFileService service;

    @Autowired
    public VideoController(VideoFileService service) {
        this.service = service;
    }

    @GetMapping(value = "/file/{id}",produces = "video/mp4")
    public Mono<ByteArrayResource> getVideoFileByID(@PathVariable("id") String id,
                                                    @RequestHeader("Range") String range) {
        log.log(Level.ALL,"Range: " + range);
        return service.findByID(id);
    }
    @PostMapping(path = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveVideo(@RequestParam("file") MultipartFile file) {
        service.save(file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
