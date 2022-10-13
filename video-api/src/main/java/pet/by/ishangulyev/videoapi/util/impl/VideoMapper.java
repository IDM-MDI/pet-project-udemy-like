package pet.by.ishangulyev.videoapi.util.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pet.by.ishangulyev.videoapi.entity.Video;
import pet.by.ishangulyev.videoapi.entity.VideoFile;
import pet.by.ishangulyev.videoapi.model.VideoModel;
import pet.by.ishangulyev.videoapi.util.ModelMapper;

import java.util.List;

public class VideoMapper implements ModelMapper<Video, VideoModel> {

    @Override
    public Video toEntity(VideoModel dto) {
        return dto == null ? null : Video.builder()
                .id(dto.getId())
                .name(dto.getName())
                .videoFile(VideoFile.builder()
                        .build()
                )
                .build();
    }

    @Override
    public VideoModel toDto(Video entity) {
        return null;
    }

    @Override
    public List<Video> toEntityList(List<VideoModel> dtoList) {
        return null;
    }

    @Override
    public List<VideoModel> toDtoList(List<Video> entityList) {
        return null;
    }
}
