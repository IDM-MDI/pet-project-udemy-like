package pet.by.ishangulyev.videoapi.util;

import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class VideoUtil {
    private VideoUtil() {}

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
    }

    public static long getDurationFromFile(MultipartFile file) throws IOException, EncoderException {
        File convertedFile = convert(file);
        MultimediaObject multimediaObject = new MultimediaObject(convertedFile);
        return multimediaObject.getInfo().getDuration();
    }
}
