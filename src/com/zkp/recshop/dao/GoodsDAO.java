package com.zkp.recshop.dao;

import com.zkp.recshop.dto.Goods;
import com.zkp.recshop.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

/**
 * 商品数据库操作实现
 */
public class GoodsDAO {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    public List<Goods> selectGoodsByBrandId(int brandId) {
        List<Goods> goodsList = null;
        try {
            String sql = "select good_id goodsId,good_name goodsName,good_img goodsImg,good_cost goodsCost,good_min_price goodsMinPrice from tb_good INNER JOIN tb_brand_good on tb_good.good_id = tb_brand_good.fk_good_id where fk_brand_id=?;";
            goodsList = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class), brandId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    public int insertGoods(Goods goods) {
        int goodsId = 0;
        try {
            String sql = "insert into tb_good(good_name,good_img,good_cost,good_min_price) values(?,?,?,?);";
            BigInteger insert = queryRunner.insert(sql, new ScalarHandler<>(), goods.getGoodsName(), goods.getGoodsImg(), goods.getGoodsCost(), goods.getGoodsMinPrice());
            goodsId = insert.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsId;
    }

    public int insertGoodsAndBrand(int goodsId, int brandId) {
        int update = 0;
        try {
            String sql = "insert into tb_brand_good(fk_brand_id,fk_good_id) values(?,?)";
            update = queryRunner.update(sql, brandId, goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int insertGoodsAndInfoDetail(int goodsId, int infoDetaulId, int price) {
        int update = 0;
        try {
            String sql = "insert into tb_good_detail(fk_good_id,fk_info_detail_id,good_discount) values(?,?,?);";
            update = queryRunner.update(sql, goodsId, infoDetaulId, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
