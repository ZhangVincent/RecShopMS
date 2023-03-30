package com.zkp.recshop.dao;

import com.zkp.recshop.dto.Category;
import com.zkp.recshop.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 分类数据库操作
 */
public class CategoryDAO {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    public List<Category> selectCategories() {
        List<Category> list = null;
        try {
            String sql = "select category_id categoryId,category_name categoryName, category_icon categoryIcon,category_status categoryStatus from tb_category;";
            list = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Category selectCategoryById(int categoryId){
        Category query = null;
        try {
            String sql = "select category_id categoryId,category_name categoryName, category_icon categoryIcon,category_status categoryStatus from tb_category where category_id=?";
            query = queryRunner.query(sql, new BeanHandler<Category>(Category.class),categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public int deleteCategoryById(int categoryId){
        int update = 0;
        try {
            String sql = "delete from tb_category where category_id=?;";
            update = queryRunner.update(sql, categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int updateCategory(Category category){
        int update = 0;
        try {
            String sql = "update tb_category set category_name=?,category_icon=?,category_status=? where category_id=?";
            update = queryRunner.update(sql, category.getCategoryName(),category.getCategoryIcon(),category.getCategoryStatus(),category.getCategoryId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int insertCategory(Category category){
        int update = 0;
        try {
            String sql = "insert into tb_category(category_name,category_icon,category_status) values(?,?,1)";
            update = queryRunner.update(sql, category.getCategoryName(),category.getCategoryIcon());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
