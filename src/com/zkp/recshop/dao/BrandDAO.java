package com.zkp.recshop.dao;

import com.zkp.recshop.dto.Brand;
import com.zkp.recshop.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

/**
 * 品牌信息数据库操作
 */
public class BrandDAO {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    public List<Brand> selectBrandsByCategoryId(int categoryId) {
        List<Brand> list = null;
        try {
            String sql = "select b.brand_id brandId,b.brand_name brandName,b.brand_logo brandLogo,b.brand_desc brandDesc,b.create_time createTime,b.brand_status brandStatus from tb_category_brand cb INNER JOIN tb_brand b ON cb.fk_brand_id = b.brand_id where cb.fk_category_id=?;";
            list = queryRunner.query(sql, new BeanListHandler<Brand>(Brand.class), categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insertBrand(Brand brand) {
        int brandId = 0;
        try {
            String sql = "insert into tb_brand(brand_name,brand_logo,brand_desc,create_time,brand_status) values(?,?,?,?,?);";
            Object[] params = {brand.getBrandName(), brand.getBrandLogo(), brand.getBrandDesc(), brand.getCreateTime(), brand.getBrandStatus()};
            BigInteger insert = queryRunner.insert(sql, new ScalarHandler<>(), params);
            brandId = insert.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brandId;
    }

    public int insertCategoryAndBrand(int cid, int bid) {
        int update = 0;
        try {
            String sql = "insert into tb_category_brand(fk_category_id,fk_brand_id) values(?,?);";
            update = queryRunner.update(sql, cid, bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public Brand selectBrandByBrandId(int brandId) {
        Brand brand = null;
        try {
            String sql = "select brand_id brandId,brand_name brandName,brand_logo brandLogo,brand_desc brandDesc,create_time createTime,brand_status brandStatus from tb_brand where brand_id=?;";
            brand = queryRunner.query(sql, new BeanHandler<Brand>(Brand.class), brandId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }

    public int updateBrand(Brand brand) {
        int update = 0;
        try {
            String sql = "update tb_brand set brand_name=?,brand_logo=?,brand_desc=?,create_time=?,brand_status=? where brand_id=?;";
            Object[] params = {brand.getBrandName(), brand.getBrandLogo(), brand.getBrandDesc(), brand.getCreateTime(), brand.getBrandStatus(), brand.getBrandId()};
            update = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int deleteCategoryAndBrand(int brandId) {
        int update = 0;
        try {
            String sql = "delete from tb_category_brand where fk_brand_id=?;";
            update = queryRunner.update(sql, brandId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int deleteBrand(int brandId) {
        int update = 0;
        try {
            String sql = "delete from tb_brand where brand_id=?;";
            update = queryRunner.update(sql, brandId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
