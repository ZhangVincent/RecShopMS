package com.zkp.test.service;

import com.zkp.recshop.dto.Menu1;
import com.zkp.recshop.dto.Menu2;
import com.zkp.recshop.service.MenuService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuServiceTest {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        List<Menu1> menu1List = menuService.listMenusByMgrId("10000006");
        for (Menu1 menu1 : menu1List) {
            System.out.println(menu1);
            for (Menu2 menu2 : menu1.getChildMenus()) {
                System.out.println(menu2);
            }
        }
    }
}