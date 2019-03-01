package com.ifit.demo.exception;

/**
 * @Author: WinstonDeng
 * @Description:
 * @Date: Created in 19:44 2019/2/25
 * @Modified by:
 */
public class MyException extends Exception {
    /**
     * 不知名错误
     */
    public static final Integer ERROR = 400;

    /**
     * id格式错误
     */
    public static final Integer ID_FORMAT_ERROR = 400;
    /**
     * 需要权限错误
     */
    public static final Integer AUTHORIZATION_ERROR = 403;
    /**
     * 资源没找到错误
     */
    public static final Integer NOT_FOUND_ERROR = 404;

    private int stateCode;

    private Object object;

    public MyException(String info, int stateCode) {
        super(info);
        this.stateCode = stateCode;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}