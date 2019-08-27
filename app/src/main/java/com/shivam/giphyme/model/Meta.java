
package com.shivam.giphyme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("response_id")
    @Expose
    private String responseId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param responseId
     * @param status
     * @param msg
     */
    public Meta(Integer status, String msg, String responseId) {
        super();
        this.status = status;
        this.msg = msg;
        this.responseId = responseId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", responseId='" + responseId + '\'' +
                '}';
    }
}
