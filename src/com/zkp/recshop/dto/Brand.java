package com.zkp.recshop.dto;

import java.util.Date;

/**
 * 物品品牌实体类
 */
public class Brand {
    private int brandId;
    private String brandName;
    private String brandLogo;
    private String brandDesc;
    private Date createTime;
    private int brandStatus;

    public Brand() {
    }

    public Brand(int brand_id, String brand_name, String brand_logo, String brand_desc, Date create_time, int brand_status) {
        this.brandId = brand_id;
        this.brandName = brand_name;
        this.brandLogo = brand_logo;
        this.brandDesc = brand_desc;
        this.createTime = create_time;
        this.brandStatus = brand_status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", brandLogo='" + brandLogo + '\'' +
                ", brandDesc='" + brandDesc + '\'' +
                ", createTime=" + createTime +
                ", brandStatus=" + brandStatus +
                '}';
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(int brandStatus) {
        this.brandStatus = brandStatus;
    }
}
