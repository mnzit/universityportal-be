package com.nepalaya.up.exception;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.util.LogUtil;

public class ResponseProcessor {

    public static Response process(ExceptionDataWrapper exceptionDataWrapper){
        try{
            return exceptionDataWrapper.handle();
        }catch (Exception ex){
            LogUtil.exception(ex);
            return ResponseBuilder.failure(ex.getMessage());
        }
    }
}
