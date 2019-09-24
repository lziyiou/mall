package com.imooc.response;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
