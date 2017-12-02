package com.lanou.entity;

/**
 * Created by lanou on 2017/12/2.
 */
public class GoodsType {

    private Integer aId;
    private String aName;
    private Integer parentId;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public GoodsType() {
        super();
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
