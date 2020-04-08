package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTON_NOT_FOUND(2001,"你找的问题迷路了"),
    TARGET_PARAM_NOT_FOUND(2002,"未找到任何问题或评论进行恢复"),
    NO_LOGIN(2003,"需要登陆之后才能操作"),
    SYS_ERROE(2004,"服务器没电了。"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在。"),
    COMMENT_NOT_FOUND(2006,"回复的评论丢失了"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空"),
    ;

    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
