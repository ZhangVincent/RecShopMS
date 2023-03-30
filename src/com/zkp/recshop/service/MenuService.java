package com.zkp.recshop.service;

import com.zkp.recshop.dao.MenuDAO;
import com.zkp.recshop.dto.Menu1;
import com.zkp.recshop.dto.Menu2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务逻辑代码实现，提供获得完整的第一类菜单、一二类菜单、指定一类菜单对应的二类菜单的方法
 */
public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    public List<Menu1> listMenusByMgrId(String mgrId) {
        List<Menu1> menu1List = menuDAO.selectMenu1ByMgrId(mgrId);
        for (int i = 0; i < menu1List.size(); i++) {
            Menu1 menu1 = menu1List.get(i);
            menu1.setChildMenus(menuDAO.selectMenu2ByMgrIdAndParentCode(mgrId, menu1.getMenuCode()));
        }
        return menu1List;
    }

    public Map<String, List> listMenus() {
        List<Menu1> menu1List = menuDAO.selectMenu1();
        List<Menu2> menu2List = menuDAO.selectMenu2();
        HashMap<String, List> menus = new HashMap<>();
        menus.put("menu1List", menu1List);
        menus.put("menu2List", menu2List);
        return menus;
    }

    public List<Menu2> listMenu2ByMenu1Code(String menu1Code) {
        List<Menu2> menu2List = menuDAO.selectMenu2ByMenu1Code(menu1Code);
        return menu2List;
    }

    private boolean changeMenuState(String menuCode, int state) {
        int updateMenuState = menuDAO.updateMenuState(menuCode, state);
        return updateMenuState > 0;
    }

    public boolean enableMenu(String menuCode) {
        return changeMenuState(menuCode, 1);
    }

    public boolean disableMenu(String menuCode) {
        return changeMenuState(menuCode, 0);
    }

    public List<Menu1> listAllMenus(){
        List<Menu1> menu1List = menuDAO.selectMenu1();
        for (Menu1 menu1:menu1List){
            menu1.setChildMenus(menuDAO.selectMenu2ByMenu1Code(menu1.getMenuCode()));
        }
        return menu1List;
    }
}
