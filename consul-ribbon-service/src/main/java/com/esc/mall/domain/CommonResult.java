package com.esc.mall.domain;

import lombok.Data;

/**
 * 通用返回
 *
 * @author jiaorun
 * @date 2022/1/6 16:01
 **/
@Data
public class CommonResult<T> {

    /**
     * 返回数据
     */
    private T data;

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    public CommonResult() {}

    public CommonResult(T data) {
        this(data, 200, "操作成功");
    }

    public CommonResult(Integer code, String message) {
        this(null, code, message);
    }

    public CommonResult(T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }
}
