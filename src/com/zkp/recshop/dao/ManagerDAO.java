package com.zkp.recshop.dao;
/**
 * 对数据库中管理员信息查询操作
 */

import com.zkp.recshop.dto.Manager;
import com.zkp.recshop.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ManagerDAO {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    public Manager selectManagerByLoginName(String loginName) {
        Manager query = null;
        try {
            String sql = "select mgr_id mgrId,login_name loginName,login_pwd loginPwd,mgr_name mgrName,mgr_gender mgrGender,mgr_tel mgrTel,mgr_email mgrEmail,mgr_qq mgrQQ,create_time createTime from tb_managers where login_name=?";
            query = queryRunner.query(sql, new BeanHandler<Manager>(Manager.class), loginName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public List<Manager> selectAllManager() {
        List<Manager> query = null;
        try {
            String sql = "select mgr_id mgrId,login_name loginName,login_pwd loginPwd,mgr_name mgrName,mgr_gender mgrGender,mgr_tel mgrTel,mgr_email mgrEmail,mgr_qq mgrQQ,create_time createTime from tb_managers";
            query = queryRunner.query(sql, new BeanListHandler<Manager>(Manager.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public int insertManager(Manager manager) {
        int update = 0;
        try {
            String sql = "insert into tb_managers(mgr_id,login_name,login_pwd,mgr_name,mgr_gender,mgr_tel,mgr_email,mgr_qq,create_time) values(?,?,?,?,?,?,?,?,?)";
            Object[] params = {manager.getMgrId(), manager.getLoginName(), manager.getLoginPwd(), manager.getMgrName(), manager.getMgrGender(), manager.getMgrTel(), manager.getMgrEmail(), manager.getMgrQQ(), manager.getCreateTime()};
            update = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int insertMgrAndRole(String mgrId,int roleId){
        int update = 0;
        try {
            String sql = "insert into tb_mgr_role(mgr_id,role_id) values(?,?);";
            update = queryRunner.update(sql, mgrId, roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int deleteMgrAndRole(String mgrId){
        int update = 0;
        try {
            String sql = "delete from tb_mgr_role where mgr_id=?;";
            update = queryRunner.update(sql, mgrId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int deleteManager(String mgrId){
        int update = 0;
        try {
            String sql = "delete from tb_managers where mgr_id=?;";
            update = queryRunner.update(sql, mgrId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public Manager selectManagerById(String mgrId){
        Manager query = null;
        try {
            String sql = "select mgr_id mgrId,login_name loginName,login_pwd loginPwd,mgr_name mgrName,mgr_gender mgrGender,mgr_tel mgrTel,mgr_email mgrEmail,mgr_qq mgrQQ,create_time createTime from tb_managers where mgr_id=?";
            query = queryRunner.query(sql, new BeanHandler<Manager>(Manager.class), mgrId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public int updateManager(Manager manager){
        int update = 0;
        try {
            String sql = "update tb_managers set login_name=?,login_pwd=?,mgr_name=?,mgr_gender=?,mgr_tel=?,mgr_email=?,mgr_qq=? where mgr_id=?";
            Object[] params = {manager.getLoginName(),manager.getLoginPwd(),manager.getMgrName(),manager.getMgrGender(),manager.getMgrTel(),manager.getMgrEmail(),manager.getMgrQQ(),manager.getMgrId()};
            update = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
