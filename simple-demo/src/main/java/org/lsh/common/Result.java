package org.lsh.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsh
 * Version: 1.0
 *
 * @Description: 业务响应对象
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    private Integer code;

    private String error;

    private String msg;

    private T data;

    private Map<String, Object> map = new HashMap<>();


    public Result(Integer code, String error, String msg, T data) {
        this.code = code;
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> ok() {
        return new Result<>(200, null, "success", null);
    }

    public static <T> Result<T> ok(String msg) {
        return new Result<>(200, null, msg, null);
    }

    public static <T> Result<T> ok(String msg, T data) {
        return new Result<>(200, null, msg, data);
    }

    public static <T> Result<T> error(int code, String error) {
        return new Result<>(code, error, null, null);
    }

    public static <T> Result<T> error(int code, String error, String msg) {
        return new Result<>(code, error, msg, null);
    }

    public Result<T> add(String key, Object value) {
        map.put(key, value);
        return this;
    }
}