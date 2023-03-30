package com.zkp.recshop.service;

import com.zkp.recshop.dao.BrandDAO;
import com.zkp.recshop.dao.CategoryDAO;
import com.zkp.recshop.dto.Brand;
import com.zkp.recshop.dto.Category;

import java.util.List;

/**
 * 分类业务实现
 */
public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();
    private BrandDAO brandDAO = new BrandDAO();

    public List<Category> listCategories(){
        return categoryDAO.selectCategories();
    }

    public boolean deleteCategory(int categoryId){
        List<Brand> brands = brandDAO.selectBrandsByCategoryId(categoryId);
        if (brands.size()>0){
            return false;
        }else {
            int i = categoryDAO.deleteCategoryById(categoryId);
            return i>0;
        }
    }

    public Category getCategoryById(int categoryId){
        return categoryDAO.selectCategoryById(categoryId);
    }

    public  boolean updateCategory(Category category){
        int i = categoryDAO.updateCategory(category);
        return i>0;
    }

    public boolean saveCategory(Category category){
        int i = categoryDAO.insertCategory(category);
        return i>0;
    }
}
