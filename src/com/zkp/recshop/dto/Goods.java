package com.zkp.recshop.dto;

/**
 * 商品实体类
 */
public class Goods {
    private int goodsId;
    private String goodsName;
    private String goodsImg;
    private int goodsCost;
    private int goodsMinPrice;
    private int goodsFirstPrice;
    private int goodsSecondPrice;
    private int goodsThirdPrice;
    private int goodsForthPrice;
    private int goodsFifthPrice;

    public Goods() {
    }

    public Goods(int goodId, String goodName, String goodImg, int goodCost, int goodMinPrice) {
        this.goodsId = goodId;
        this.goodsName = goodName;
        this.goodsImg = goodImg;
        this.goodsCost = goodCost;
        this.goodsMinPrice = goodMinPrice;
    }

    public Goods(int goodId, String goodName, String goodImg, int goodCost, int goodMinPrice, int goodFirstPrice, int goodSecondPrice, int goodThirdPrice, int goodForthPrice, int goodFifthPrice) {
        this.goodsId = goodId;
        this.goodsName = goodName;
        this.goodsImg = goodImg;
        this.goodsCost = goodCost;
        this.goodsMinPrice = goodMinPrice;
        this.goodsFirstPrice = goodFirstPrice;
        this.goodsSecondPrice = goodSecondPrice;
        this.goodsThirdPrice = goodThirdPrice;
        this.goodsForthPrice = goodForthPrice;
        this.goodsFifthPrice = goodFifthPrice;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodId=" + goodsId +
                ", goodName='" + goodsName + '\'' +
                ", goodImg='" + goodsImg + '\'' +
                ", goodCost=" + goodsCost +
                ", goodMinPrice=" + goodsMinPrice +
                ", goodFirstPrice=" + goodsFirstPrice +
                ", goodSecondPrice=" + goodsSecondPrice +
                ", goodThirdPrice=" + goodsThirdPrice +
                ", goodForthPrice=" + goodsForthPrice +
                ", goodFifthPrice=" + goodsFifthPrice +
                '}';
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public int getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(int goodsCost) {
        this.goodsCost = goodsCost;
    }

    public int getGoodsMinPrice() {
        return goodsMinPrice;
    }

    public void setGoodsMinPrice(int goodsMinPrice) {
        this.goodsMinPrice = goodsMinPrice;
    }

    public int getGoodsFirstPrice() {
        return goodsFirstPrice;
    }

    public void setGoodsFirstPrice(int goodsFirstPrice) {
        this.goodsFirstPrice = goodsFirstPrice;
    }

    public int getGoodsSecondPrice() {
        return goodsSecondPrice;
    }

    public void setGoodsSecondPrice(int goodsSecondPrice) {
        this.goodsSecondPrice = goodsSecondPrice;
    }

    public int getGoodsThirdPrice() {
        return goodsThirdPrice;
    }

    public void setGoodsThirdPrice(int goodsThirdPrice) {
        this.goodsThirdPrice = goodsThirdPrice;
    }

    public int getGoodsForthPrice() {
        return goodsForthPrice;
    }

    public void setGoodsForthPrice(int goodsForthPrice) {
        this.goodsForthPrice = goodsForthPrice;
    }

    public int getGoodsFifthPrice() {
        return goodsFifthPrice;
    }

    public void setGoodsFifthPrice(int goodsFifthPrice) {
        this.goodsFifthPrice = goodsFifthPrice;
    }
}
