package com.zkp.recshop.dao;

import com.zkp.recshop.dto.BasicInfo;
import com.zkp.recshop.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 类目数据库操作
 */
public class BasicInfoDAO {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    public List<BasicInfo> selectBasicInfos() {
        List<BasicInfo> query = null;
        try {
            String sql = "select basic_info_id basicInfoId,basic_info_name basicInfoName,basic_info_status basicInfoStatus from tb_basic_info;";
            query = queryRunner.query(sql, new BeanListHandler<BasicInfo>(BasicInfo.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public int insertBasicInfo(BasicInfo basicInfo){
        int update = 0;
        try {
            String sql = "insert into tb_basic_info(basic_info_name,basic_info_status) values(?,?);";
            update = queryRunner.update(sql, basicInfo.getBasicInfoName(), basicInfo.getBasicInfoStatus());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public BasicInfo selectBasicInfoById(int basicInfoId){
        BasicInfo basicInfo = null;
        try {
            String sql = "select basic_info_id basicInfoId,basic_info_name basicInfoName,basic_info_status basicInfoStatus from tb_basic_info where basic_info_id=?;";
            basicInfo = queryRunner.query(sql, new BeanHandler<BasicInfo>(BasicInfo.class), basicInfoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return basicInfo;
    }

    public int updateBasicInfo(BasicInfo basicInfo){
        int update = 0;
        try {
            String sql = "update tb_basic_info set basic_info_name=?,basic_info_status=? where basic_info_id=?";
            update = queryRunner.update(sql, basicInfo.getBasicInfoName(), basicInfo.getBasicInfoStatus(), basicInfo.getBasicInfoId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int deleteBasicInfoById(int basicInfoId){
        int update = 0;
        try {
            String sql = "delete from tb_basic_info where basic_info_id=?";
            update = queryRunner.update(sql, basicInfoId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
