package pet.by.ishangulyev.userservice.exception;

public enum UserExceptionCode {
    NOTHING_FIND_BY_ID(1000,"NOTHING FIND BY ID"),
    USER_ALREADY_EXIST(1001,"USER ALREADY EXIST"),
    USER_NOT_EXIST(1002,"USER NOT EXIST"),
    USER_NOT_VALID(1003,"USER NOT VALID");
    private final int code;
    private final String name;

    UserExceptionCode(int code,String name) {
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
