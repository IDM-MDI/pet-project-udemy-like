package pet.by.ishangulyev.videoapi.util.impl;

import org.springframework.stereotype.Component;
import pet.by.ishangulyev.videoapi.entity.VideoFile;
import pet.by.ishangulyev.videoapi.model.VideoFileModel;
import pet.by.ishangulyev.videoapi.util.ModelMapper;

import java.util.List;

@Component
public class VideoFileMapper implements ModelMapper<VideoFile, VideoFileModel> {
    @Override
    public VideoFile toEntity(VideoFileModel dto) {
        return dto == null ? null : VideoFile.builder()
                .id(dto.getId())
                .file(dto.getFile())
                .build();
    }

    @Override
    public VideoFileModel toModel(VideoFile entity) {
        return entity == null ? null : VideoFileModel.builder()
                .id(entity.getId())
                .file(entity.getFile())
                .build();
    }

    @Override
    public List<VideoFile> toEntityList(List<VideoFileModel> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }

    @Override
    public List<VideoFileModel> toModelList(List<VideoFile> entityList) {
        return entityList.stream().map(this::toModel).toList();
    }
}
