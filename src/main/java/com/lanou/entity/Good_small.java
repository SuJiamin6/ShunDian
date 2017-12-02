package com.lanou.entity;

/**
 * Created by lanou on 2017/12/2.
 */
public class Good_small {

    private Integer gId;
    private String gName;

    @Override
    public String toString() {
        return "Good_small{" +
                "gId=" + gId +
                ", gName='" + gName + '\'' +
                '}';
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Good_small() {
        super();
    }
}
