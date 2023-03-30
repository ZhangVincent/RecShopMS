package com.zkp.recshop.dao;

import com.zkp.recshop.dto.Menu1;
import com.zkp.recshop.dto.Menu2;
import com.zkp.recshop.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 提供查询第一类menu和第二类menu的方法
 */

public class MenuDAO {
    public List<Menu1> selectMenu1ByMgrId(String mgrId) {
        List<Menu1> menu1List = new ArrayList<>();
        try {
            String sql = "select c.menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,menu_icon menuIcon from tb_mgr_role a inner join tb_role_menu b inner join tb_menus c on a.role_id=b.role_id and b.menu_id=c.menu_id where a.mgr_id=? and c.menu_level=1 order by c.menu_order";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menu1List = queryRunner.query(sql, new BeanListHandler<Menu1>(Menu1.class), mgrId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu1List;
    }

    public List<Menu2> selectMenu2ByMgrIdAndParentCode(String mgrId, String parentCode) {
        List<Menu2> menu2List = new ArrayList<>();
        try {
            String sql = "select c.menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,parent_menu_code parentMenuCode,menu_url menuUrl,menu_state menuState from tb_mgr_role a inner join tb_role_menu b inner join tb_menus c on a.role_id = b.role_id and b.menu_id = c.menu_id where a.mgr_id=? and c.menu_level=2 and c.parent_menu_code=? order by c.menu_order";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menu2List = queryRunner.query(sql, new BeanListHandler<Menu2>(Menu2.class), mgrId, parentCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu2List;
    }

    public List<Menu1> selectMenu1() {
        List<Menu1> menu1List = new ArrayList<>();
        try {
            String sql = "select menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,menu_icon menuIcon from tb_menus where menu_level=1 order by menu_order;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menu1List = queryRunner.query(sql, new BeanListHandler<Menu1>(Menu1.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu1List;
    }

    public List<Menu2> selectMenu2() {
        List<Menu2> menu2List = new ArrayList<>();
        try {
            String sql = "select menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,parent_menu_code parentMenuCode,menu_url menuUrl,menu_state menuState from tb_menus where menu_level=2 order by menu_order;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menu2List = queryRunner.query(sql, new BeanListHandler<Menu2>(Menu2.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu2List;
    }

    public List<Menu2> selectMenu2ByMenu1Code(String parentCode) {
        List<Menu2> menu2List = new ArrayList<>();
        try {
            String sql = "select menu_id menuId,menu_code menuCode,menu_name menuName,menu_order menuOrder,menu_level menuLevel,parent_menu_code parentMenuCode,menu_url menuUrl,menu_state menuState from tb_menus where parent_menu_code=? order by menu_order;";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            menu2List = queryRunner.query(sql, new BeanListHandler<Menu2>(Menu2.class),parentCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu2List;
    }

    public int updateMenuState(String menuCode,int state) {
        int update = 0;
        try {
            String sql = "update tb_menus set menu_state=? where menu_code=?;";
            Object[] params = {state, menuCode};
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            update = queryRunner.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }
}
