package com.yin.girledemo.handle;

import com.yin.girledemo.domain.Result;
import com.yin.girledemo.exception.GirlException;
import com.yin.girledemo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private static final Logger log= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result Handle(Exception e){
        if (e instanceof GirlException ){
            GirlException girlException=(GirlException)e;
            return ResultUtil.error(1,e.getMessage());
        }else {
            log.error("系统异常");
            return ResultUtil.error(00000,"系统异常"+e.getMessage());
        }
    }

}
