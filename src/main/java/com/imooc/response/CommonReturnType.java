package com.imooc.response;

import lombok.Data;

@Data
public class CommonReturnType {
    private String status;
    private Object data;

    public CommonReturnType(Object result) {
        this("success", result);
    }

    public CommonReturnType(String status, Object data) {
        this.status = status;
        this.data = data;
    }
}
