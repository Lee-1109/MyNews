package com.service.impl;

import com.dao.IAdminDAO;
import com.dao.IEssayDAO;
import com.dao.IPublishDAO;
import com.dao.IReaderDAO;
import com.model.Admin;
import com.model.Essay;
import com.model.Publish;
import com.model.Reader;
import com.service.IAdminService;
import com.util.Page;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 17:47
 * @Version 1.0
 */

public class AdminServiceImpl implements IAdminService {

    private IAdminDAO adminDAO;
    private IReaderDAO readerDAO;
    private IEssayDAO essayDAO;
    private IPublishDAO publishDAO;

    public void setAdminDAO(IAdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public void setReaderDAO(IReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
    }

    public void setEssayDAO(IEssayDAO essayDAO) {
        this.essayDAO = essayDAO;
    }

    public void setPublishDAO(IPublishDAO publishDAO) {
        this.publishDAO = publishDAO;
    }

    /**
     * 管理员权限的更改
     * @param request
     * @param admin 管理员信息
     * @param grant 更改后的权限
     * @return
     */
    @Override
    public boolean grant(HttpServletRequest request,Admin admin, int grant) {
        HttpSession session = request.getSession();
        Admin admin1 = (Admin) session.getAttribute("nowUser");
        if(admin1.getGrants()>grant){//检查授权的管理权限
            System.out.println("you need heigher grant!");
            return false;
        }else {
            admin.setGrants(grant);
            return adminDAO.updateGrant(admin);
        }
    }

    /**
     * 获取所有管理员
     * @return
     */
    @Override
    public List<Admin> listAdmin(){
         return adminDAO.list();
    }

    @Override
    public List<Admin> listAdminByCondition(HashMap<String,Object> map) {
        return adminDAO.listByCondition(map);
    }

    @Override
    public List<Admin> listAdminByPage(HashMap<String,Object> map) {
        Page page= (Page) map.get("page");
        map.put("startPos",page.getStartPos());
        map.put("pageSize",page.getPageSize());
        return adminDAO.listByPage(map);
    }

    @Override
    public List<Admin> listAdminByConditionByPage(HashMap<String, Object> map) {
        Page page= (Page) map.get("page");
        map.put("startPos",page.getStartPos());
        map.put("pageSize",page.getPageSize());
        return adminDAO.listByConditionByPage(map);
    }

    /**
     * 获取所有读者
     * @return
     */
    @Override
    public List<Reader> listReader() {
        return readerDAO.list();
    }

    @Override
    public List<Reader> listReaderByPage(HashMap<String, Object> map) {
        //展示page页的管理员信息
        Page page= (Page) map.get("page");
        map.put("startPos",page.getStartPos());
        map.put("pageSize",page.getPageSize());
        return readerDAO.listByPage(map);
    }

    /**
     * 获取所有文章
     * @return
     */
    @Override
    public List<Essay> listEssay() {
        return essayDAO.list();
    }

    /**
     * 分页获取所有文章
     * @param map map包含了所有参数
     * @return 文章列表
     */
    @Override
    public List<Essay> listEssayByPage(HashMap<String, Object> map) {
        //展示page页的管理员信息
        Page page= (Page) map.get("page");
        map.put("startPos",page.getStartPos());
        map.put("pageSize",page.getPageSize());
        return essayDAO.listByPage(map);
    }

    /**
     * 获取所有出版社
     * @return
     */
    @Override
    public List<Publish> listPublish() {
        return publishDAO.list();
    }

    @Override
    public List<Publish> listPublishByPage(HashMap<String,Object> map) {
        //展示page页的管理员信息
        Page page= (Page) map.get("page");
        map.put("startPos",page.getStartPos());
        map.put("pageSize",page.getPageSize());
        return publishDAO.listByPage(map);
    }
}
