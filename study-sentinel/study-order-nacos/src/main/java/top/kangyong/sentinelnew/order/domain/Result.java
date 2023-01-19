package top.kangyong.sentinelnew.order.domain;

import lombok.Data;

/**
 * @author Kang Yong
 * @date 2023/1/12
 * @since 1.0.0
 */
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Result() {
    }

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

    public static Result success(Object data) {
        return new Result(3001, "操作成功", data);
    }

}
