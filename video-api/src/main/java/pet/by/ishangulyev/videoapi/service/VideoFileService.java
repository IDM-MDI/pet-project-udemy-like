package pet.by.ishangulyev.videoapi.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pet.by.ishangulyev.videoapi.entity.VideoFile;
import pet.by.ishangulyev.videoapi.repository.VideoFileRepository;
import reactor.core.publisher.Mono;

@Service
public class VideoFileService {
    private final VideoFileRepository videoFileRepository;

    @Autowired
    public VideoFileService(VideoFileRepository videoFileRepository) {
        this.videoFileRepository = videoFileRepository;
    }

    public Mono<ByteArrayResource> findByID(String id) {
        VideoFile videoFile = videoFileRepository.findById(id).orElseThrow();
        return Mono.just(new ByteArrayResource(videoFile.getFile()));
    }

    @SneakyThrows
    public void save(MultipartFile file) {
        videoFileRepository.save(VideoFile.builder()
                .file(file.getBytes())
                .build());
    }



}
