package pet.by.ishangulyev.videoapi.exception;

public enum VideoExceptionCode {
    NOTHING_FIND_BY_ID(1000,"NOTHING FIND BY ID"),
    FILE_NOT_VIDEO(1001,"FILE IS NOT VIDEO"),
    FILE_NOT_EXIST(1002,"FILE NOT EXIST"),
    ERROR_UNPACKING_FILE(1003,"ERROR WHILE UNPACKING FILE"),
    ERROR_ENCODING_FILE(1004,"ERROR WHILE ENCODING FILE")
    ;
    private final int code;
    private final String name;

    VideoExceptionCode(int code,String name) {
        this.code = code;
        this.name = name;
    }
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
