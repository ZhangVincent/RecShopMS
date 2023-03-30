package com.zkp.test.dao;
/**
 * 对ManagerDAO进行测试
 */

import com.zkp.recshop.dao.ManagerDAO;
import com.zkp.recshop.dto.Manager;
import org.junit.Assert;

import java.util.List;

public class ManagerDAOTest {
    private static ManagerDAO managerDAO = new ManagerDAO();

    public static void selectByLoginName(){
        Manager admin = managerDAO.selectManagerByLoginName("admin");
        System.out.println(admin);
        Assert.assertNotNull(admin);
    }

    public static void selectAll(){
        List<Manager> manager = managerDAO.selectAllManager();
        for (Manager mgr:manager){
            System.out.println(mgr.toString());
        }
    }

    public static void main(String[] args) {
        selectByLoginName();
        selectAll();
    }
}
