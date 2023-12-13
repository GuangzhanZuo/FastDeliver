package com.qingyang.fastdeliver.util;

import java.io.Serializable;

public class JsonResult<E> implements Serializable {

    /*状态码*/
    private Integer state;
    /*描述信息*/
    private String message;
    /*数据*/
    private E data;

    public JsonResult(){

    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e){
        this.message=e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public E getData() {
        return data;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(E data) {
        this.data = data;
    }

}
