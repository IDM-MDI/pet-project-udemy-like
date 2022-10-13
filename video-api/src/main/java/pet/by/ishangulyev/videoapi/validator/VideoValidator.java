package pet.by.ishangulyev.videoapi.validator;

import java.io.File;

import static pet.by.ishangulyev.videoapi.util.VideoUtil.getFileExtension;

public class VideoValidator {
    private static final String VIDEO_FORMAT = ".mp4";
    private VideoValidator() {}

    public static boolean isFileValid(File file) {
        String extension = getFileExtension(file);
        return !extension.isBlank() && extension.matches(VIDEO_FORMAT);
    }
}
