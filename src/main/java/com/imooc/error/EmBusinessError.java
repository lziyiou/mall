package com.imooc.error;

public enum EmBusinessError implements CommonError {
    //用户信息相关错误
    USER_NOT_EXIST(10001, "用户不存在"),
    USER_LOGIN_FAIL(10002, "手机号或密码不正确"),
    //通用错误类型
    PARAMETER_VALIDATION_ERROR(20001, "参数不合法"),
    UNKNOWN_ERROR(20002, "未知错误"),
    //交易信息相关错误
    STOCK_NOT_ENOUGH(30001, "库存不足")
    ;

    private int errCode;
    private String errMsg;

    EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
