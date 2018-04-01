package com.yin.girledemo.exception;

import com.yin.girledemo.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GirlException extends RuntimeException {
    private static final Logger log= LoggerFactory.getLogger(GirlException.class);
    private Integer code;
    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
