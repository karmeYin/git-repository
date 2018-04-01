package com.yin.girledemo.utils;


import com.yin.girledemo.domain.Result;

public class ResultUtil {
    public static Result  success(Object data){
        Result result=new Result();
        result.setData(data);
        result.setMsg("成功");
        result.setCode(1);
        return result;
    }
    public static Result success(){
       return   success(null);
    }
    public static Result error(Integer code, String msg,Object object) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
    public static Result error(Integer code,String msg){
        return error(code,msg,null);
    }


}
