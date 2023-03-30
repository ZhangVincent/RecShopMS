package com.zkp.recshop.dto;

import java.util.List;

/**
 * 一级菜单，拥有图标和二级菜单的菜单
 */

public class Menu1 {
    private int menuId;
    private String menuCode;
    private String menuName;
    private int menuOrder;
    private int menuLevel;
    private String menuIcon;
    //当前⼀级菜单中包含的⼆级菜单
    private List<Menu2> childMenus;
    private boolean haveMenu; //⽤于标识当前⻆⾊是由拥有该权限菜单

    public Menu1() {
    }

    public Menu1(int menuId, String menuCode, String menuName, int menuOrder, int menuLevel, String menuIcon, List<Menu2> childMenus, boolean haveMenu) {
        this.menuId = menuId;
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuOrder = menuOrder;
        this.menuLevel = menuLevel;
        this.menuIcon = menuIcon;
        this.childMenus = childMenus;
        this.haveMenu = haveMenu;
    }

    @Override
    public String toString() {
        return "Menu1{" +
                "menuId=" + menuId +
                ", menuCode='" + menuCode + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuOrder=" + menuOrder +
                ", menuLevel=" + menuLevel +
                ", menuIcon='" + menuIcon + '\'' +
                ", childMenus=" + childMenus +
                ", haveMenu=" + haveMenu +
                '}';
    }

    public boolean isHaveMenu() {
        return haveMenu;
    }

    public void setHaveMenu(boolean haveMenu) {
        this.haveMenu = haveMenu;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public List<Menu2> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu2> childMenus) {
        this.childMenus = childMenus;
    }
}
