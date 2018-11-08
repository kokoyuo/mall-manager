package com.kokoyuo.mall.manager.modules.sys.pojo;


import com.alibaba.fastjson.annotation.JSONField;

public class Result {

    private Status status;

    private Object data;

    public static final Result SUCCESS_INSTANCE = new Result(Status.SUCCESS_INSTANCE);

    public static final Result FAILED_INSTANCE = new Result(Status.FAILED_INSTANCE);

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(Status status, Object data) {
        this.status = status;
        this.data = data;
    }
    public Result(Status status) {
        this.status = status;
    }

    public Result() {
    }

    @JSONField(serialize = false)
    public static Result getDefaultSuccessResult(Object data)
    {
        return new Result(new Status(Status.RETURN_TYPE.SUCCESS),data);
    }

}
