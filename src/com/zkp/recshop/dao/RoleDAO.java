package com.zkp.recshop.dao;

import com.zkp.recshop.dto.Role;
import com.zkp.recshop.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 完成角色数据库操作
 */
public class RoleDAO {
    public List<Role> selectRoles() {
        List<Role> roleList = null;
        try {
            String sql = "select role_id roleId,role_name roleName,role_desc roleDesc from tb_roles;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            roleList = queryRunner.query(sql, new BeanListHandler<Role>(Role.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    public int insertRole(Role role) {
        int res = 0;
        try {
            String sql = "insert into tb_roles(role_name,role_desc) values(?,?);";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            BigInteger insert = queryRunner.insert(sql, new ScalarHandler<>(), role.getRoleName(), role.getRoleDesc());
            res = insert.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public int insertRoleAndMenu(int roleId, int menuId) {
        int res = 0;
        try {
            String sql = "insert into tb_role_menu(role_id,menu_id) values(?,?);";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            res = queryRunner.update(sql, roleId, menuId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public int deleteRoleAndMenuByRoleId(int roleId) {
        int update = 0;
        try {
            String sql = "delete from tb_role_menu where role_id=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            update = queryRunner.update(sql, roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public int deleteRoleByRoleId(int roleId) {
        int update = 0;
        try {
            String sql = "delete from tb_roles where role_id=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            update = queryRunner.update(sql, roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    public Role selectRoleById(int roleId) {
        Role role = null;
        try {
            String sql = "select role_id roleId,role_name roleName,role_desc roleDesc from tb_roles where role_id=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            role = queryRunner.query(sql, new BeanHandler<Role>(Role.class), roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public List<Integer> selectMenuIdsByRoleId(int roleId) {
        List<Integer> menuIds = null;
        try {
            String sql = "select menu_id from tb_role_menu where role_id=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//            menuIds = queryRunner.query(sql, new BeanListHandler<Integer>(Integer.class), roleId);
//            这里不能直接用Integer
            ResultSetHandler<List<Integer>> resultSetHandler = new ResultSetHandler<>() {
                @Override
                public List<Integer> handle(ResultSet resultSet) throws SQLException {
                    List<Integer> list = new ArrayList<>();
                    while (resultSet.next()) {
                        int mid = resultSet.getInt("menu_id");
                        list.add(mid);
                    }
                    return list;
                }
            };
            menuIds = queryRunner.query(sql, resultSetHandler, roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuIds;
    }

    public int updateRole(Role role) {
        int update = 0;
        try {
            String sql = "update tb_roles set role_name=?,role_desc=? where role_id=?;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            update = queryRunner.update(sql, role.getRoleName(), role.getRoleDesc(), role.getRoleId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
