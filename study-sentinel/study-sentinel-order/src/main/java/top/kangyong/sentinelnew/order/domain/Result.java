package top.kangyong.sentinelnew.order.domain;

import java.io.Serializable;

/**
 * @author Kang Yong
 * @date 2023/1/12
 * @since 1.0.0
 */
public class Result<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg);
    }

}
