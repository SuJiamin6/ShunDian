package com.lanou.entity;

/**
 * Created by lanou on 2017/12/2.
 */
public class Floor {

    private Integer floorId;
    private String floorName;

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId=" + floorId +
                ", floorName='" + floorName + '\'' +
                '}';
    }

    public Floor() {
        super();
    }
}
