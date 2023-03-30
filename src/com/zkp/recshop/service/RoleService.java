package com.zkp.recshop.service;

import com.zkp.recshop.dao.RoleDAO;
import com.zkp.recshop.dto.Role;

import java.util.List;

/**
 * 角色相关业务实现
 */
public class RoleService {
    private RoleDAO roleDao = new RoleDAO();

    public List<Role> getRoles() {
        List<Role> roleList = roleDao.selectRoles();
        return roleList;
    }

    public boolean addRole(Role role, String[] menuIds) {
        boolean res = true;
        int roleId = roleDao.insertRole(role);
        if (menuIds != null) {
            for (String menuId : menuIds) {
                int i = roleDao.insertRoleAndMenu(roleId, Integer.parseInt(menuId));
                if (i <= 0) {
                    res = false;
                }
            }
        }
        return res;
    }

    public boolean deleteRole(int roleId) {
        int i = roleDao.deleteRoleAndMenuByRoleId(roleId);
        int res = roleDao.deleteRoleByRoleId(roleId);
        return res > 0;
    }

    public Role getRoleById(int roleId) {
        return roleDao.selectRoleById(roleId);
    }

    public List<Integer> getMenuIdsByRoleId(int roleId) {
        return roleDao.selectMenuIdsByRoleId(roleId);
    }

    public boolean updateRole(Role role,String[] menuIds){
        int i = roleDao.updateRole(role);
        int i1 = roleDao.deleteRoleAndMenuByRoleId(role.getRoleId());
        for (String s:menuIds){
            int menuId = Integer.parseInt(s);
            int i2 = roleDao.insertRoleAndMenu(role.getRoleId(), menuId);
        }
        return i>0;
    }
}
