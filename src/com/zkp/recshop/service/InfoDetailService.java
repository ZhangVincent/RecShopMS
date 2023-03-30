package com.zkp.recshop.service;

import com.zkp.recshop.dao.InfoDetailDAO;
import com.zkp.recshop.dto.InfoDetail;

import java.util.List;

/**
 * 评估选项业务实现
 */
public class InfoDetailService {
    private InfoDetailDAO infoDetailDAO = new InfoDetailDAO();

    public List<InfoDetail> listInfoDetailByBasicInfoId(int basicInfoId) {
        return infoDetailDAO.selectInfoDetailsByBasicInfoId(basicInfoId);
    }

    public boolean saveInfoDetail(InfoDetail infoDetail) {
        return infoDetailDAO.insertInfoDetail(infoDetail) > 0;
    }

    public boolean deleteInfoDetail(int infoDetailId) {
        return infoDetailDAO.deleteInfoDetail(infoDetailId) > 0;
    }
}
