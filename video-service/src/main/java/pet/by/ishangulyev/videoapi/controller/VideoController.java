package pet.by.ishangulyev.videoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pet.by.ishangulyev.videoapi.exception.VideoException;
import pet.by.ishangulyev.videoapi.model.VideoModel;
import pet.by.ishangulyev.videoapi.service.impl.VideoInfoService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    private final VideoInfoService service;

    @Autowired
    public VideoController(VideoInfoService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public VideoModel getVideoInfoByID(@PathVariable("id") String id) throws VideoException {
        return service.findModelByID(id);
    }
    @GetMapping(value = "/file/{id}",produces = "video/mp4")
    public Mono<ByteArrayResource> getVideoFileByID(@PathVariable("id") String id,
                                                    @RequestHeader("Range") String range) throws VideoException {
        return service.streamByID(id);
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveVideoFile(@RequestParam("file") MultipartFile file,
                                                @RequestParam("name") String name) throws VideoException {
        service.save(name,file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideoFile(@PathVariable("id") String id) throws VideoException {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
