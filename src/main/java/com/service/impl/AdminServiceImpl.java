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
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<Admin> listAdminByCondition( HashMap<String,Object> map) {
        return adminDAO.listByCondition(map);
    }

    @Override
    public List<Admin> listAdminByPage(HashMap<String,Object> map) {
        map = initQuery(map);
        return adminDAO.listByPage(map);
    }

    @Override
    public List<Admin> listAdminByConditionByPage(HashMap<String, Object> map) {
        String condition = (String) map.get("condition");
        map.put("condition","%"+condition+"%");
        map = initQuery(map);
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
        map = initQuery(map);
        return readerDAO.listByPage(map);
    }

    @Override
    public List<Reader> listReaderByCondition(HashMap<String, Object> map) {
        List<Reader> readers = readerDAO.listByCondition(map);
        for (Reader reader : readers){
            System.out.println("listReaderByCondition:"+"    reader:"+reader.getUsername());
        }
        return readers;
    }

    @Override
    public List<Reader> listReaderByConditionByPage(HashMap<String, Object> map) {
        map = initQuery(map);
        List<Reader> readers = readerDAO.listByConditionByPage(map);
        for (Reader reader : readers){
            System.out.println("listReaderByConditionByPage"+"reader"+reader.toString());
        }
        return readerDAO.listByConditionByPage(map);
    }

    /**
     * 获取所有文章
     * @return
     */

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
        map = initQuery(map);
        return publishDAO.listByPage(map);
    }

    @Override
    public List<Publish> listPublishByCondition(HashMap<String, Object> map) {
        return publishDAO.listByCondition(map);
    }

    @Override
    public List<Publish> listPublishByConditionByPage(HashMap<String, Object> map) {
        map = initQuery(map);
        return publishDAO.listByConditionByPage(map);
    }

    /**
     * 批量删除管理员列表
     * @param map
     * @return
     */
    @Override
    public boolean deleteList(HashMap<String, Object> map) {
        List<Admin> admins = (List<Admin>) map.get("adminList");
        return adminDAO.deleteList(admins);

    }

    private HashMap<String,Object> initQuery(HashMap<String,Object> map){
        Page page= (Page) map.get("page");
        map.put("startPos",page.getStartPos());
        map.put("pageSize",page.getPageSize());
        return map;
    }
}
