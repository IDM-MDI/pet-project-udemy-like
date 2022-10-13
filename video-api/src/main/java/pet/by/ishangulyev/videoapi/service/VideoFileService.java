package pet.by.ishangulyev.videoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pet.by.ishangulyev.videoapi.entity.VideoFile;
import pet.by.ishangulyev.videoapi.exception.VideoException;
import pet.by.ishangulyev.videoapi.repository.VideoFileRepository;
import reactor.core.publisher.Mono;

import java.io.IOException;

import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.ERROR_UNPACKING_FILE;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.FILE_NOT_EXIST;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.FILE_NOT_VIDEO;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.NOTHING_FIND_BY_ID;
import static pet.by.ishangulyev.videoapi.validator.VideoValidator.isFileValid;

@Service
public class VideoFileService {
    private final VideoFileRepository videoFileRepository;

    @Autowired
    public VideoFileService(VideoFileRepository videoFileRepository) {
        this.videoFileRepository = videoFileRepository;
    }

    public VideoFile findByID(String id) throws VideoException {
        return videoFileRepository.findById(id)
                .orElseThrow(() -> new VideoException(NOTHING_FIND_BY_ID.toString()));
    }

    public boolean isFileExist(String id) {
        return videoFileRepository.existsById(id);
    }

    public void delete(String id) throws VideoException {
        if(!isFileExist(id)) {
            throw new VideoException(FILE_NOT_EXIST.toString());
        }
        videoFileRepository.deleteById(id);
    }

    public String save(MultipartFile file) throws VideoException {
        if(!isFileValid(file)) {
            throw new VideoException(FILE_NOT_VIDEO.toString());
        }
        try {
            return videoFileRepository.save(VideoFile.builder()
                    .file(file.getBytes())
                    .build())
                    .getId();
        } catch (IOException exception) {
            throw new VideoException(ERROR_UNPACKING_FILE.toString());
        }
    }


    public Mono<ByteArrayResource> streamByID(String id) throws VideoException {
        return Mono.just(new ByteArrayResource(findByID(id).getFile()));
    }
}
