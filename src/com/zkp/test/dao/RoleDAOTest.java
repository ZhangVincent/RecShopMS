package com.zkp.test.dao;

import com.zkp.recshop.dao.RoleDAO;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleDAOTest {
    @Test
    public static void main(String[] args) {
        RoleDAO roleDAO = new RoleDAO();
        System.out.println(roleDAO.selectRoleById(1));
        System.out.println(roleDAO.selectMenuIdsByRoleId(2));
    }
}