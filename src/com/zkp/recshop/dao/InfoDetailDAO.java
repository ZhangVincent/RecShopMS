package com.zkp.recshop.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.zkp.recshop.dto.InfoDetail;
import com.zkp.recshop.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 评估选项数据库操作
 */
public class InfoDetailDAO {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    public List<InfoDetail> selectInfoDetailsByBasicInfoId(int basicInfoId) {
        List<InfoDetail> infoDetailList = null;
        try {
            String sql = "select info_detail_id infoDetailId,info_detail_name infoDetailName,info_detail_desc infoDetailDesc from tb_info_detail where fk_basic_info_id=?;";
            infoDetailList = queryRunner.query(sql, new BeanListHandler<InfoDetail>(InfoDetail.class), basicInfoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return infoDetailList;
    }

    public int insertInfoDetail(InfoDetail infoDetail) {
        int update = 0;
        try {
            String sql = "insert into tb_info_detail(info_detail_name,info_detail_desc,fk_basic_info_id) values(?,?,?);";
            update = queryRunner.update(sql, infoDetail.getInfoDetailName(), infoDetail.getInfoDetailDesc(), infoDetail.getFkBasicInfoId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int deleteInfoDetail(int infoDetailId) {
        int update = 0;
        try {
            String sql = "delete from tb_info_detail where info_detail_id=?;";
            update = queryRunner.update(sql, infoDetailId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
