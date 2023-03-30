package com.zkp.recshop.dto;

/**
 * 评估选项实体类
 */
public class InfoDetail {
    private int infoDetailId;
    private String infoDetailName;
    private String infoDetailDesc;
    private int fkBasicInfoId;

    public InfoDetail() {
    }

    public InfoDetail(int infoDetailId, String infoDetailName, String infoDetailDesc, int fkBasicInfoId) {
        this.infoDetailId = infoDetailId;
        this.infoDetailName = infoDetailName;
        this.infoDetailDesc = infoDetailDesc;
        this.fkBasicInfoId = fkBasicInfoId;
    }

    @Override
    public String toString() {
        return "InfoDetail{" +
                "infoDetailId=" + infoDetailId +
                ", infoDetailName='" + infoDetailName + '\'' +
                ", infoDetailDesc='" + infoDetailDesc + '\'' +
                ", fkBasicInfoId=" + fkBasicInfoId +
                '}';
    }

    public int getInfoDetailId() {
        return infoDetailId;
    }

    public void setInfoDetailId(int infoDetailId) {
        this.infoDetailId = infoDetailId;
    }

    public String getInfoDetailName() {
        return infoDetailName;
    }

    public void setInfoDetailName(String infoDetailName) {
        this.infoDetailName = infoDetailName;
    }

    public String getInfoDetailDesc() {
        return infoDetailDesc;
    }

    public void setInfoDetailDesc(String infoDetailDesc) {
        this.infoDetailDesc = infoDetailDesc;
    }

    public int getFkBasicInfoId() {
        return fkBasicInfoId;
    }

    public void setFkBasicInfoId(int fkBasicInfoId) {
        this.fkBasicInfoId = fkBasicInfoId;
    }
}
