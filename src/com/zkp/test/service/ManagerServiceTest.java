package com.zkp.test.service;

import com.zkp.recshop.dto.Manager;
import com.zkp.recshop.service.ManagerService;

public class ManagerServiceTest {
    private static ManagerService managerService = new ManagerService();

    private static void checkLoginTest() {
        Manager admin1 = managerService.checkLogin("admin", "123123");
        Manager admin2 = managerService.checkLogin("admin", "1");
        Manager admin3 = managerService.checkLogin("a", "123123");
        Manager admin4 = managerService.checkLogin("vincent", "1111");
        System.out.println(admin1);
        System.out.println(admin2);
        System.out.println(admin3);
        System.out.println(admin4);
    }

    public static void main(String[] args) {
        checkLoginTest();
    }
}
