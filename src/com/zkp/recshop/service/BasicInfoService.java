package com.zkp.recshop.service;

import com.zkp.recshop.dao.BasicInfoDAO;
import com.zkp.recshop.dto.BasicInfo;

import java.util.List;

/**
 * 类目具体业务逻辑实现
 */
public class BasicInfoService {
    private BasicInfoDAO basicInfoDAO = new BasicInfoDAO();

    public List<BasicInfo> listBasicInfos() {
        return basicInfoDAO.selectBasicInfos();
    }

    public boolean saveBasicInfo(BasicInfo basicInfo) {
        int i = basicInfoDAO.insertBasicInfo(basicInfo);
        return i > 0;
    }

    public BasicInfo getBasicInfoById(int basicInfoId) {
        return basicInfoDAO.selectBasicInfoById(basicInfoId);
    }

    public boolean updateBasicInfo(BasicInfo basicInfo) {
        int i = basicInfoDAO.updateBasicInfo(basicInfo);
        return i > 0;
    }

    public boolean deleteBasicInfoById(int basicInfoId) {
        int i = basicInfoDAO.deleteBasicInfoById(basicInfoId);
        return i > 0;
    }
}
