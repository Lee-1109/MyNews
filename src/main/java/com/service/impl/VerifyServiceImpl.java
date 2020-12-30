package com.service.impl;

import com.dao.IEssayDAO;
import com.model.Admin;
import com.model.Essay;
import com.service.IVerifyService;
import com.util.Page;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/30 12:25
 * @Version 1.0
 */

public class VerifyServiceImpl implements IVerifyService {

    private IEssayDAO essayDAO;
    public void setEssayDAO(IEssayDAO essayDAO) {
        this.essayDAO = essayDAO;
    }


    @Override
    public boolean passEssay(HashMap<String,Object> map) {
        Admin admin = (Admin) map.get("doAdmin");
        Essay essay = (Essay) map.get("verifyEssay");
        map.put("essayId",essay.getAid());//传入文章的ID
        map.put("status",1);
        map.put("doAdminId",admin.getId());
        map.put("updateTime",new Date(System.currentTimeMillis()));
        return this.essayDAO.updateVerify(map);
    }

    @Override
    public boolean unPassEssay(HashMap<String,Object> map) {
        Admin admin = (Admin) map.get("doAdmin");
        Essay essay = (Essay) map.get("verifyEssay");
        map.put("essayId",essay.getAid());//传入文章的ID
        map.put("status",0);
        map.put("doAdminId",admin.getId());
        return this.essayDAO.updateVerify(map);
    }

    @Override
    public List<Essay> listReview() {
        return essayDAO.listReview();
    }

    @Override
    public List<Essay> listReviewByPage(HashMap<String,Object> map) {
        Page page= (Page) map.get("page");
        map.put("startPos",page.getStartPos());
        map.put("pageSize",page.getPageSize());
        return essayDAO.listReviewByPage(map);
    }

    @Override
    public boolean delete(String essayId) {
        return essayDAO.deleteEssay(essayId);
    }


}
