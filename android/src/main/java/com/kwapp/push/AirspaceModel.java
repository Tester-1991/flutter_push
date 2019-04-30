package com.kwapp.push;

import java.io.Serializable;

/**
 * 空域类型
 * Created by 13096 on 2018/8/11.
 */

public class AirspaceModel implements Serializable {


    /**
     * id : 2-1541152702580
     * beforeState : AIRSPACE_UNLOCKED
     * afterState : COUNTDOWN_UNLOCK_THE_AIRSPACE
     * applyAirArea : 337.59
     * flightHeight : 1000
     * startTime : 2018-10-28 16:00:00
     * endTime : 2018-10-29 16:00:00
     * applyPlaneView : {"planeId":574,"planeType":1,"planeTypeName":"固定翼","planeBrand":"迈凯飞","planeVersion":"UV20","planeWeight":18,"ceilingHeight":2000,"ceilingFlightTime":55,"planeImageUrl":"https://airspace-test.oss-cn-beijing.aliyuncs.com/200914566815813632/7b8295eb44ff39ee3a926933389138f8.png"}
     */

    private String id;
    private String beforeState;
    private String afterState;
    private double applyAirArea;
    private int flightHeight;
    private String startTime;
    private String endTime;
    private String flightAreaName;
    private ApplyPlaneViewBean applyPlaneView;
    private String areaType;
    private String callCenterId;
    private String taskId;
    private long countdown;

    public long getCountdown() {
        return countdown;
    }

    public void setCountdown(long countdown) {
        this.countdown = countdown;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCallCenterId() {
        return callCenterId;
    }

    public void setCallCenterId(String callCenterId) {
        this.callCenterId = callCenterId;
    }

    public String getFlightAreaName() {
        return flightAreaName;
    }

    public void setFlightAreaName(String flightAreaName) {
        this.flightAreaName = flightAreaName;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeforeState() {
        return beforeState;
    }

    public void setBeforeState(String beforeState) {
        this.beforeState = beforeState;
    }

    public String getAfterState() {
        return afterState;
    }

    public void setAfterState(String afterState) {
        this.afterState = afterState;
    }

    public double getApplyAirArea() {
        return applyAirArea;
    }

    public void setApplyAirArea(double applyAirArea) {
        this.applyAirArea = applyAirArea;
    }

    public int getFlightHeight() {
        return flightHeight;
    }

    public void setFlightHeight(int flightHeight) {
        this.flightHeight = flightHeight;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public ApplyPlaneViewBean getApplyPlaneView() {
        return applyPlaneView;
    }

    public void setApplyPlaneView(ApplyPlaneViewBean applyPlaneView) {
        this.applyPlaneView = applyPlaneView;
    }

    public static class ApplyPlaneViewBean implements Serializable {
        /**
         * planeId : 574
         * planeType : 1
         * planeTypeName : 固定翼
         * planeBrand : 迈凯飞
         * planeVersion : UV20
         * planeWeight : 18
         * ceilingHeight : 2000
         * ceilingFlightTime : 55
         * planeImageUrl : https://airspace-test.oss-cn-beijing.aliyuncs.com/200914566815813632/7b8295eb44ff39ee3a926933389138f8.png
         */

        private long planeId;
        private int planeType;
        private String planeTypeName;
        private String planeBrand;
        private String planeVersion;
        private double planeWeight;
        private double ceilingHeight;
        private int ceilingFlightTime;
        private String planeImageUrl;

        public long getPlaneId() {
            return planeId;
        }

        public void setPlaneId(long planeId) {
            this.planeId = planeId;
        }

        public int getPlaneType() {
            return planeType;
        }

        public void setPlaneType(int planeType) {
            this.planeType = planeType;
        }

        public String getPlaneTypeName() {
            return planeTypeName;
        }

        public void setPlaneTypeName(String planeTypeName) {
            this.planeTypeName = planeTypeName;
        }

        public String getPlaneBrand() {
            return planeBrand;
        }

        public void setPlaneBrand(String planeBrand) {
            this.planeBrand = planeBrand;
        }

        public String getPlaneVersion() {
            return planeVersion;
        }

        public void setPlaneVersion(String planeVersion) {
            this.planeVersion = planeVersion;
        }

        public double getPlaneWeight() {
            return planeWeight;
        }

        public void setPlaneWeight(double planeWeight) {
            this.planeWeight = planeWeight;
        }

        public double getCeilingHeight() {
            return ceilingHeight;
        }

        public void setCeilingHeight(double ceilingHeight) {
            this.ceilingHeight = ceilingHeight;
        }

        public int getCeilingFlightTime() {
            return ceilingFlightTime;
        }

        public void setCeilingFlightTime(int ceilingFlightTime) {
            this.ceilingFlightTime = ceilingFlightTime;
        }

        public String getPlaneImageUrl() {
            return planeImageUrl;
        }

        public void setPlaneImageUrl(String planeImageUrl) {
            this.planeImageUrl = planeImageUrl;
        }
    }
}
