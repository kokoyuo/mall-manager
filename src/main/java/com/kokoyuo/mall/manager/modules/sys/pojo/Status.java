package com.kokoyuo.mall.manager.modules.sys.pojo;


import com.alibaba.fastjson.annotation.JSONField;

public class Status{

    public enum RETURN_TYPE{
        SUCCESS(200),FAILED(500);

        private int code;

        RETURN_TYPE(int code) {
            this.code = code;
        }
    }

    public static final Status SUCCESS_INSTANCE = new Status(RETURN_TYPE.SUCCESS);

    public static final Status FAILED_INSTANCE = new Status(RETURN_TYPE.FAILED);

    private int code;
    private String msg;


    /**
     * 状态码，200标示成功，其他任何值标示失败
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 状态码，0标示成功，其他任何值标示失败
     * @return
     */
    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Status(RETURN_TYPE type) {
        this.code = type.code;
        this.msg = type.name();
    }

    public Status(int code) {
        this.code = code;
    }


}
