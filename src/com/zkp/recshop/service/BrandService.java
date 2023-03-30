package com.zkp.recshop.service;

import com.zkp.recshop.dao.BrandDAO;
import com.zkp.recshop.dao.GoodsDAO;
import com.zkp.recshop.dto.Brand;
import com.zkp.recshop.dto.Goods;

import java.util.List;

/**
 * 品牌业务实现
 */
public class BrandService {
    private BrandDAO brandDAO = new BrandDAO();
    private GoodsDAO goodsDAO = new GoodsDAO();

    public List<Brand> listBrandsByCategoryId(int categoryId) {
        return brandDAO.selectBrandsByCategoryId(categoryId);
    }

    public boolean addBrand(Brand brand, int categoryId) {
        int brandId = brandDAO.insertBrand(brand);
        int i = brandDAO.insertCategoryAndBrand(categoryId, brandId);
        return i > 0;
    }

    public Brand getBrandById(int brandId) {
        return brandDAO.selectBrandByBrandId(brandId);
    }

    public boolean updateBrand(Brand brand) {
        int i = brandDAO.updateBrand(brand);
        return i > 0;
    }

    public boolean deleteBrandById(int brandId) {
        List<Goods> goodsList = goodsDAO.selectGoodsByBrandId(brandId);
        if (goodsList.size() == 0) {
            int i = brandDAO.deleteCategoryAndBrand(brandId);
            if (i > 0) {
                int j = brandDAO.deleteBrand(brandId);
                return j > 0;
            }
        }
        return false;
    }
}
