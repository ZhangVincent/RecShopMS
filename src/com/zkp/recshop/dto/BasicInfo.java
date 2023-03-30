package com.zkp.recshop.dto;

import java.util.List;

/**
 * 回收类目实体类
 */
public class BasicInfo {
    private int basicInfoId;
    private String basicInfoName;
    private int basicInfoStatus;
    private List<InfoDetail> infoDetailList;//定义infoDetailList属性，存放当前类⽬下的选项

    public BasicInfo() {
    }

    public BasicInfo(int basic_info_id, String basic_info_name, int basic_info_status) {
        this.basicInfoId = basic_info_id;
        this.basicInfoName = basic_info_name;
        this.basicInfoStatus = basic_info_status;
    }

    public BasicInfo(int basicInfoId, String basicInfoName, int basicInfoStatus, List<InfoDetail> infoDetailList) {
        this.basicInfoId = basicInfoId;
        this.basicInfoName = basicInfoName;
        this.basicInfoStatus = basicInfoStatus;
        this.infoDetailList = infoDetailList;
    }

    @Override
    public String toString() {
        return "BasicInfo{" +
                "basicInfoId=" + basicInfoId +
                ", basicInfoName='" + basicInfoName + '\'' +
                ", basicInfoStatus=" + basicInfoStatus +
                ", infoDetailList=" + infoDetailList +
                '}';
    }

    public List<InfoDetail> getInfoDetailList() {
        return infoDetailList;
    }

    public void setInfoDetailList(List<InfoDetail> infoDetailList) {
        this.infoDetailList = infoDetailList;
    }

    public int getBasicInfoId() {
        return basicInfoId;
    }

    public void setBasicInfoId(int basicInfoId) {
        this.basicInfoId = basicInfoId;
    }

    public String getBasicInfoName() {
        return basicInfoName;
    }

    public void setBasicInfoName(String basicInfoName) {
        this.basicInfoName = basicInfoName;
    }

    public int getBasicInfoStatus() {
        return basicInfoStatus;
    }

    public void setBasicInfoStatus(int basicInfoStatus) {
        this.basicInfoStatus = basicInfoStatus;
    }
}
