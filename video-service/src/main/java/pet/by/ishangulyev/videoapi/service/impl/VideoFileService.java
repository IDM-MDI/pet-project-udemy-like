package pet.by.ishangulyev.videoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.by.ishangulyev.videoapi.entity.VideoFile;
import pet.by.ishangulyev.videoapi.exception.VideoException;
import pet.by.ishangulyev.videoapi.model.VideoFileModel;
import pet.by.ishangulyev.videoapi.repository.VideoFileRepository;
import pet.by.ishangulyev.videoapi.service.VideoService;
import pet.by.ishangulyev.videoapi.util.impl.VideoFileMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.FILE_NOT_EXIST;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.FILE_NOT_VIDEO;
import static pet.by.ishangulyev.videoapi.exception.VideoExceptionCode.NOTHING_FIND_BY_ID;
import static pet.by.ishangulyev.videoapi.validator.VideoValidator.isFileValid;

@Service
public class VideoFileService implements VideoService<VideoFile, VideoFileModel> {
    private final VideoFileRepository videoFileRepository;
    private final VideoFileMapper mapper;

    @Autowired
    public VideoFileService(VideoFileRepository videoFileRepository, VideoFileMapper mapper) {
        this.videoFileRepository = videoFileRepository;
        this.mapper = mapper;
    }

    @Override
    public VideoFile findByID(String id) throws VideoException {
        return videoFileRepository.findById(id)
                .orElseThrow(() -> new VideoException(NOTHING_FIND_BY_ID.toString()));
    }

    @Override
    public VideoFileModel findModelByID(String id) throws VideoException {
        return mapper.toModel(findByID(id));
    }

    @Override
    public boolean isEntityExist(String id) {
        return videoFileRepository.existsById(id);
    }
    @Override
    public void delete(String id) throws VideoException {
        if(!isEntityExist(id)) {
            throw new VideoException(FILE_NOT_EXIST.toString());
        }
        videoFileRepository.deleteById(id);
    }

    public VideoFile save(File file) throws VideoException, IOException {
        if(!isFileValid(file)) {
            throw new VideoException(FILE_NOT_VIDEO.toString());
        }
        byte[] bytes = Files.readAllBytes(file.toPath());
        file.delete();
        return videoFileRepository.save(VideoFile.builder().file(bytes).build());
    }
}
