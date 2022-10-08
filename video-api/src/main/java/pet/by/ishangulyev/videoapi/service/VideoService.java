package pet.by.ishangulyev.videoapi.service;

import com.google.common.primitives.Bytes;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pet.by.ishangulyev.videoapi.entity.VideoFile;
import pet.by.ishangulyev.videoapi.model.StreamFileInfo;
import pet.by.ishangulyev.videoapi.repository.VideoFileRepository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

@Service
public class VideoService {
    private final VideoFileRepository videoFileRepository;

    @Autowired
    public VideoService(VideoFileRepository videoFileRepository) {
        this.videoFileRepository = videoFileRepository;
    }

    public StreamFileInfo getVideoFileByID(String id, String range) {
        VideoFile videoFile = videoFileRepository.findById(id).orElseThrow();
        int length = videoFile.getFile().length;
        long chunkSize = length / 10;
        HttpRange httpRange = HttpRange.parseRanges(range).stream().findFirst().orElseThrow();

        long rangeStart = httpRange.getRangeStart(0);
        long rangeEnd = rangeStart + chunkSize;
        if (rangeEnd >= length) {
            rangeEnd = length - 1;
        }
        long contentLength = rangeEnd - rangeStart + 1;
        return StreamFileInfo.builder()
                .rangeStart(rangeStart)
                .rangeEnd(rangeEnd)
                .fileSize(length)
                .contentLength(contentLength)
                .responseBody(out -> {
                    try(ByteArrayInputStream inputStream = new ByteArrayInputStream(videoFile.getFile())) {
                        inputStream.skip(rangeStart);
                        byte[] bytes = inputStream.readNBytes((int) contentLength);
                        out.write(bytes);
                    }
                })
                .build();
    }

    @SneakyThrows
    public void saveVideo(MultipartFile file) {
        videoFileRepository.save(VideoFile.builder()
                .file(file.getBytes())
                .build());
        System.out.println(file);
    }
}
