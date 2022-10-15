package pet.by.ishangulyev.videoapi.util.impl;

import org.springframework.stereotype.Component;
import pet.by.ishangulyev.videoapi.entity.Video;
import pet.by.ishangulyev.videoapi.entity.VideoFile;
import pet.by.ishangulyev.videoapi.model.VideoModel;
import pet.by.ishangulyev.videoapi.util.ModelMapper;

import java.util.List;

@Component
public class VideoMapper implements ModelMapper<Video, VideoModel> {
    @Override
    public Video toEntity(VideoModel model) {
        return model == null ? null : Video.builder()
                .id(model.getId())
                .name(model.getName())
                .size(model.getSize())
                .length(model.getLength())
                .videoFile(VideoFile.builder()
                        .id(model.getVideoFileID())
                        .build()
                )
                .build();
    }

    @Override
    public VideoModel toModel(Video entity) {
        return entity == null ? null : VideoModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .size(entity.getSize())
                .length(entity.getLength())
                .videoFileID(entity.getVideoFile().getId())
                .build();
    }

    @Override
    public List<Video> toEntityList(List<VideoModel> modelList) {
        return modelList.stream().map(this::toEntity).toList();
    }

    @Override
    public List<VideoModel> toModelList(List<Video> entityList) {
        return entityList.stream().map(this::toModel).toList();
    }
}
