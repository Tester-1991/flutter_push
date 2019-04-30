package com.kwapp.push;

import java.io.Serializable;

/**
 * websocket发送的model
 * Created by 13096 on 2018/8/11.
 */

public class SocketModel implements Serializable {

    /**
     * data : "{\"id\":\"1\"}"
     * id : AIRSPACE-123-1
     * message : string
     * messageType : AIRSPACE
     */

    //是一个带有flyerId的原始数据
    private String data;

    private String id;

    private String message;

    private String messageType;
    //是否已读
    private boolean read;
    //发送时间
    private String createTime;
    //消息中心列表时候使用
    private AirspaceModel airspaceModel;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public AirspaceModel getAirspaceModel() {
        return airspaceModel;
    }

    public void setAirspaceModel(AirspaceModel airspaceModel) {
        this.airspaceModel = airspaceModel;
    }

    @Override
    public String toString() {
        return "SocketModel{" +
                "data='" + data + '\'' +
                ", id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", messageType='" + messageType + '\'' +
                ", read=" + read +
                ", createTime='" + createTime + '\'' +
                ", airspaceModel=" + airspaceModel +
                '}';
    }
}
