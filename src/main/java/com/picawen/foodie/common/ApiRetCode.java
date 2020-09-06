package com.picawen.foodie.common;

/**
 * API 错误码
 *
 * @author Sven.Fu
 * @date 2020/9/6 8:12 下午
 */
public interface ApiRetCode {

    int CODE_SUCCESS = 0;
    String MESSAGE_SUCCESS = "success";

    int CODE_EXCEPTION = 1;
    String MESSAGE_EXCEPTION = "fail";
}
