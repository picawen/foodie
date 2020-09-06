package com.picawen.foodie.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 通用响应消息体
 *
 * @author Sven.Fu
 * @date 2020/9/6 8:07 下午
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 7765151526171520901L;

    private int code = ApiRetCode.CODE_SUCCESS;
    private String message = ApiRetCode.MESSAGE_SUCCESS;
    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        this.message = msg;
    }

    public R(Throwable e) {
        super();
        this.message = e.getMessage();
        this.code = ApiRetCode.CODE_EXCEPTION;
    }

    public R(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public R(String message) {
        super();
        this.code = ApiRetCode.CODE_EXCEPTION;
        this.message = message;
    }
}
