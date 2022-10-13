package pet.by.ishangulyev.videoapi.util;

import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.info.MultimediaInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class VideoUtil {
    private static final String PATH = "D:\\Project\\Videos\\";
    private VideoUtil() {}

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(
                PATH + file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
    }

    public static long getDurationFromFile(File file) throws IOException, EncoderException {
        return new MultimediaObject(file)
                .getInfo()
                .getDuration() / 1000;
    }

    public static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf);
    }
}
