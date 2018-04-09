package com.bx.card.util;


import com.bx.card.Result;

public class ResultUtil {
    public static <T> Result<T> success(T data){
        return success(data,"成功");
    }
    public static <T> Result<T> success(T data,String msg){
        Result<T> result = new Result<>();
        result.setCode("0");
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    public static Result fail(String msg){
        return fail("1", msg);
    }
    public static Result fail(String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
