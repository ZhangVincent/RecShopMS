package com.zkp.recshop.service;

import com.zkp.recshop.dao.ManagerDAO;
import com.zkp.recshop.dto.Manager;
import com.zkp.recshop.utils.MD5Utils;

import java.util.List;

/**
 * 管理员业务层逻辑实现
 */

public class ManagerService {
    private ManagerDAO managerDAO = new ManagerDAO();

    public Manager checkLogin(String loginName, String loginPwd) {
        Manager manager = managerDAO.selectManagerByLoginName(loginName);
        if (manager != null) {
            if (manager.getLoginPwd().equals(MD5Utils.md5Encode(loginPwd))) {
                return manager;
            }
        }
        return null;
    }

    public List<Manager> listManagers() {
        return managerDAO.selectAllManager();
    }

    public boolean saveManager(Manager manager, int roleId) {
        manager.setLoginPwd(MD5Utils.md5Encode(manager.getLoginPwd()));
        ManagerDAO managerDAO = new ManagerDAO();
        int i = managerDAO.insertManager(manager);
        int i1 = managerDAO.insertMgrAndRole(manager.getMgrId(), roleId);
        return i > 0;
    }

    public boolean deleteManager(String mgrId) {
        int i = managerDAO.deleteManager(mgrId);
        int i1 = managerDAO.deleteMgrAndRole(mgrId);
        return i > 0;
    }

    public Manager getManagerById(String mgrId) {
        return managerDAO.selectManagerById(mgrId);
    }

    public boolean updateManager(Manager manager, int roleId) {
        if (manager.getLoginPwd() == null || manager.getLoginPwd().equals("")) {
            Manager managerOld = managerDAO.selectManagerById(manager.getMgrId());
            manager.setLoginPwd(managerOld.getLoginPwd());
        } else {
            manager.setLoginPwd(MD5Utils.md5Encode(manager.getLoginPwd()));
        }

        int i = managerDAO.updateManager(manager);
        if (i > 0) {
            int i1 = managerDAO.deleteMgrAndRole(manager.getMgrId());
            int i2 = managerDAO.insertMgrAndRole(manager.getMgrId(), roleId);
        }
        return i > 0;
    }
}
