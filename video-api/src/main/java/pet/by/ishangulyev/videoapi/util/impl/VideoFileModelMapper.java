package pet.by.ishangulyev.videoapi.util.impl;

import pet.by.ishangulyev.videoapi.entity.VideoFile;
import pet.by.ishangulyev.videoapi.model.VideoFileModel;
import pet.by.ishangulyev.videoapi.util.ModelMapper;

import java.util.List;

public class VideoFileModelMapper implements ModelMapper<VideoFile, VideoFileModel> {
    @Override
    public VideoFile toEntity(VideoFileModel dto) {
        return dto == null ? null : VideoFile.builder()
                .id(dto.getId())
                .file(dto.getFile())
                .build();
    }

    @Override
    public VideoFileModel toDto(VideoFile entity) {
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
    public List<VideoFileModel> toDtoList(List<VideoFile> entityList) {
        return entityList.stream().map(this::toDto).toList();
    }
}
