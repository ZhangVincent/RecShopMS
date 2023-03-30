package com.zkp.recshop.dto;

/**
 * 二级菜单，根据parentMenuCode附属在一级菜单下
 */

public class Menu2 {
    private int menuId;
    private String menuCode;
    private String menuName;
    private int menuOrder;
    private int menuLevel;
    private String parentMenuCode;
    private String menuUrl;
    private int menuState; //用于表示当前二级菜单是否正常工作
    private boolean haveMenu; //⽤于标识当前⻆⾊是由拥有该权限菜单

    public Menu2() {
    }

    public Menu2(int menuId, String menuCode, String menuName, int menuOrder, int menuLevel, String parentMenuCode, String menuUrl, int menuState, boolean haveMenu) {
        this.menuId = menuId;
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuOrder = menuOrder;
        this.menuLevel = menuLevel;
        this.parentMenuCode = parentMenuCode;
        this.menuUrl = menuUrl;
        this.menuState = menuState;
        this.haveMenu = haveMenu;
    }

    @Override
    public String toString() {
        return "Menu2{" +
                "menuId=" + menuId +
                ", menuCode='" + menuCode + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuOrder=" + menuOrder +
                ", menuLevel=" + menuLevel +
                ", parentMenuCode='" + parentMenuCode + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuState=" + menuState +
                ", haveMenu=" + haveMenu +
                '}';
    }

    public boolean isHaveMenu() {
        return haveMenu;
    }

    public void setHaveMenu(boolean haveMenu) {
        this.haveMenu = haveMenu;
    }

    public int getMenuState() {
        return menuState;
    }

    public void setMenuState(int menuState) {
        this.menuState = menuState;
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

    public String getParentMenuCode() {
        return parentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        this.parentMenuCode = parentMenuCode;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
