package pet.by.ishangulyev.videoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pet.by.ishangulyev.videoapi.entity.Video;
import pet.by.ishangulyev.videoapi.exception.VideoException;
import pet.by.ishangulyev.videoapi.model.VideoModel;
import pet.by.ishangulyev.videoapi.repository.VideoRepository;
import pet.by.ishangulyev.videoapi.service.VideoService;
import pet.by.ishangulyev.videoapi.util.VideoUtil;
import reactor.core.publisher.Mono;
import ws.schild.jave.EncoderException;

import java.io.IOException;

import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.ERROR_ENCODING_FILE;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.ERROR_UNPACKING_FILE;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.FILE_NOT_EXIST;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.NOTHING_FIND_BY_ID;

@Service
public class VideoInfoService implements VideoService<Video, VideoModel> {
    private final VideoRepository videoRepository;
    private final VideoFileService videoFileService;

    @Autowired
    public VideoInfoService(VideoRepository videoRepository, VideoFileService videoFileService) {
        this.videoRepository = videoRepository;
        this.videoFileService = videoFileService;
    }

    @Override
    public Video findByID(String id) throws VideoException {
        return videoRepository.findById(id)
                .orElseThrow(() -> new VideoException(NOTHING_FIND_BY_ID.toString()));
    }

    @Override
    public boolean isEntityExist(String id) {
        return videoRepository.existsById(id);
    }

    @Override
    public void delete(String id) throws VideoException {
        if(!isEntityExist(id)) {
            throw new VideoException(FILE_NOT_EXIST.toString());
        }
        videoRepository.deleteById(id);
    }

    @Transactional
    public void save(String name,MultipartFile file) throws VideoException {
        try {
            videoRepository.save(buildSaveVideo(name, file));
        } catch (IOException exception) {
            throw new VideoException(ERROR_UNPACKING_FILE.toString());
        } catch (EncoderException e) {
            throw new VideoException(ERROR_ENCODING_FILE.toString());
        }
    }

    public Mono<ByteArrayResource> streamByID(String id) throws VideoException {
        return Mono.just(new ByteArrayResource(videoFileService.findByID(id).getFile()));
    }

    private Video buildSaveVideo(String name, MultipartFile file) throws EncoderException, IOException, VideoException {
        int size = file.getBytes().length;
        long duration = VideoUtil.getDurationFromFile(file);

        return Video.builder().name(name)
                .length(duration)
                .size(size)
                .videoFile(
                        videoFileService.save(file)
                )
                .build();
    }
}
