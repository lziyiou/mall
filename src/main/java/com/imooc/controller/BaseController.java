package com.imooc.controller;

import com.imooc.error.BusinessException;
import com.imooc.error.EmBusinessError;
import com.imooc.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(Exception ex) {
        Map<String, Object> responseBody = new HashMap<>();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseBody.put("errMsg", businessException.getErrMsg());
            responseBody.put("errCode", businessException.getErrCode());
        } else {
            responseBody.put("errMsg", EmBusinessError.UNKNOWN_ERROR.getErrMsg());
            responseBody.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
        }
        return new CommonReturnType("fail", responseBody);
    }



}
