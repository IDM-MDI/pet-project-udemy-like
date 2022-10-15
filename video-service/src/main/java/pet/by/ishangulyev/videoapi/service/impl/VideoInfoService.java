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
import pet.by.ishangulyev.videoapi.util.impl.VideoMapper;
import reactor.core.publisher.Mono;
import ws.schild.jave.EncoderException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.ERROR_ENCODING_FILE;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.ERROR_UNPACKING_FILE;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.FILE_NOT_EXIST;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.NOTHING_FIND_BY_ID;
import static pet.by.ishangulyev.videoapi.util.VideoUtil.convert;

@Service
public class VideoInfoService implements VideoService<Video, VideoModel> {
    private final VideoRepository videoRepository;
    private final VideoFileService videoFileService;
    private final VideoMapper mapper;

    @Autowired
    public VideoInfoService(VideoRepository videoRepository, VideoFileService videoFileService, VideoMapper mapper) {
        this.videoRepository = videoRepository;
        this.videoFileService = videoFileService;
        this.mapper = mapper;
    }

    @Override
    public Video findByID(String id) throws VideoException {
        return videoRepository.findById(id)
                .orElseThrow(() -> new VideoException(NOTHING_FIND_BY_ID.toString()));
    }

    @Override
    public VideoModel findModelByID(String id) throws VideoException {
        return mapper.toModel(findByID(id));
    }

    @Override
    public boolean isEntityExist(String id) {
        return videoRepository.existsById(id);
    }

    @Override
    @Transactional
    public void delete(String id) throws VideoException {
        if(!isEntityExist(id)) {
            throw new VideoException(FILE_NOT_EXIST.toString());
        }
        String fileID = findByID(id).getVideoFile().getId();
        videoFileService.delete(fileID);
        videoRepository.deleteById(id);
    }

    @Transactional
    public void save(String name, MultipartFile multipartFile) throws VideoException {
        try {
            videoRepository.save(buildSaveVideo(name, convert(multipartFile)));
        } catch (IOException exception) {
            throw new VideoException(ERROR_UNPACKING_FILE.toString());
        } catch (EncoderException e) {
            throw new VideoException(ERROR_ENCODING_FILE.toString());
        }
    }

    public Mono<ByteArrayResource> streamByID(String id) throws VideoException {
        return Mono.just(new ByteArrayResource(videoFileService.findByID(id).getFile()));
    }

    private Video buildSaveVideo(String name, File file) throws EncoderException, IOException, VideoException {
        byte[] bytes = Files.readAllBytes(file.toPath());
        double size = (bytes.length / 1024f) / 1024f;
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
