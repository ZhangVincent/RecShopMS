package com.zkp.test.dao;

import com.zkp.recshop.dao.MenuDAO;

import static org.junit.jupiter.api.Assertions.*;

class MenuDAOTest {
    public static void main(String[] args) {
        MenuDAO menuDAO = new MenuDAO();
        System.out.println(menuDAO.selectMenu1());
        System.out.println(menuDAO.selectMenu2());
    }
}