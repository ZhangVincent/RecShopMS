package com.zkp.recshop.service;

import com.zkp.recshop.dao.GoodsDAO;
import com.zkp.recshop.dto.Goods;

import java.util.List;

/**
 * 商品业务
 */
public class GoodsService {
    private GoodsDAO goodsDAO = new GoodsDAO();

    public List<Goods> selectGoodsByBrandId(int brandId) {
        return goodsDAO.selectGoodsByBrandId(brandId);
    }

    public int saveGoods(Goods goods, int brandId) {
        int goodsId = goodsDAO.insertGoods(goods);
        if (goodsId > 0) {
            int i = goodsDAO.insertGoodsAndBrand(goodsId, brandId);
            if (i > 0) {
                return goodsId;
            }
        }
        return 0;
    }

    public boolean saveGoodsAndInfoDetail(int goodsId, int infoDetailId, int price) {
        int i = goodsDAO.insertGoodsAndInfoDetail(goodsId, infoDetailId, price);
        return i > 0;
    }
}
