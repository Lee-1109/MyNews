package com.controller;

import com.model.Admin;
import com.model.Publish;
import com.model.Reader;
import com.service.IAdminService;
import com.util.AdminListVo;
import com.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 17:44
 * @Version 1.0
 */

@Controller
public class AdminController {

    @Resource(description = "adminService")
    private IAdminService adminService;

    /**
     * 权限的授予
     * @return
     */
    @RequestMapping("/grantController")
    public String grant(HttpServletRequest request, Admin admin, @RequestParam("grant")int grant){
        if(adminService.grant(request,admin,grant)){
            return "listAdmin";
        }else {
            return "adminMain";
        }

    }

    @RequestMapping("/adminPublish")
    public String listPublish(HttpServletRequest request,HashMap<String,Object> map){
        String pageNow=request.getParameter("pageNow");
        if (null == pageNow) pageNow ="1";
        int pageN=Integer.parseInt(pageNow);//获取当前页

        int totalPageCount = adminService.listPublish().size();
        Page page=new Page(totalPageCount,pageN);
        page.setPageSize(5);
        map.put("url","adminPublish");
        map.put("page",page);

        List<Publish> publishes = adminService.listPublishByPage(map);
        map.put("publishes",publishes);
        return "adminPublish";
    }

    @RequestMapping("/adminPublishByCondition")
    public String listPublishByCondition(HttpServletRequest request,HashMap<String,Object> map){
        String pageNow=request.getParameter("pageNow");
        String condition=request.getParameter("condition");
        map.put("condition","%"+condition+"%");
        if (null == pageNow) pageNow ="1";
        int pageN=Integer.parseInt(pageNow);
        //获取当前页

        int totalPageCount=adminService.listPublishByCondition(map).size();
        Page page=new Page(totalPageCount,pageN);
        page.setPageSize(8);
        map.put("url","adminPublishByCondition");
        map.put("page",page);
        List<Publish> publishes = adminService.listPublishByConditionByPage(map);
        map.put("publishes",publishes);
        return "adminPublish";
    }

    @RequestMapping("/adminGrant")
    public String listAdmin(HttpServletRequest request,HashMap<String,Object> map){
        String pageNow=request.getParameter("pageNow");
        if (null == pageNow) pageNow ="1";
        int pageN=Integer.parseInt(pageNow);//获取当前页
        int totalPageCount=adminService.listAdmin().size();
        Page page=new Page(totalPageCount,pageN);
        page.setPageSize(5);
        //设置处理的URL
        map.put("url","adminGrant");
        map.put("page",page);
        List<Admin> admins = adminService.listAdminByPage(map);
        map.put("admins",admins);
        return "adminGrant";
    }

    @RequestMapping("/listAdminByCondition")
    public String listAdminByCondition(HttpServletRequest request,HashMap<String,Object> map){
        String pageNow=request.getParameter("pageNow");
        String condition = request.getParameter("condition");
        if (null == pageNow) pageNow ="1";
        int pageN=Integer.parseInt(pageNow);//获取当前页
        map.put("condition","%"+condition+"%");
        int totalPageCount=adminService.listAdminByCondition(map).size();
        Page page=new Page(totalPageCount,pageN);
        page.setPageSize(5);
        //设置处理的URL
        map.put("url","adminGrant");
        map.put("page",page);
        List<Admin> admins = adminService.listAdminByConditionByPage(map);
        map.put("admins",admins);
        return "adminGrant";
    }

    @RequestMapping("/adminReader")
    public String listReader(HttpServletRequest request,HashMap<String,Object> map){
        String pageNow=request.getParameter("pageNow");
        if (null == pageNow) pageNow ="1";
        int pageN=Integer.parseInt(pageNow);//获取当前页
        int totalPageCount=adminService.listReader().size();
        Page page=new Page(totalPageCount,pageN);
        page.setPageSize(5);
        //设置处理的URL
        map.put("url","adminReader");
        map.put("page",page);
        List<Reader> readers = adminService.listReaderByPage(map);
        map.put("readers",readers);
        return "adminReader";
    }

    /**
     * 条件分页查询
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/adminReaderByCondition")
    public String listReaderByCondition(HttpServletRequest request,HashMap<String,Object> map){
        String pageNow=request.getParameter("pageNow");
        String condition = request.getParameter("condition");
        map.put("condition","%"+condition+"%");
        if (null == pageNow) pageNow ="1";
        int pageN=Integer.parseInt(pageNow);//获取当前页
        int totalPageCount=adminService.listReaderByCondition(map).size();
        Page page=new Page(totalPageCount,pageN);
        page.setPageSize(8);
        //设置处理的URL
        map.put("url","adminReaderByCondition");
        map.put("page",page);
        List<Reader> readers = adminService.listReaderByConditionByPage(map);
        map.put("readers",readers);
        return "adminReader";
    }

    /**
     * 批量删除管理员
     * @param adminListVo   存储了管理员的列表包装类
     * @param map
     * @return
     */
    @RequestMapping("/deleteAdminList")
    public String deleteList(AdminListVo adminListVo, HashMap<String,Object> map){
        //获取批量删除的学生列表
        List<Admin> adminList = adminListVo.getAdminList();
        //批量删除的量为空
        if(adminList.isEmpty()) return "error";
        //将处理的学生列表传递给adminService
        map.put("adminList",adminList);
        if(adminService.deleteList(map)){
            return "adminGrant";
        }else {
            return "error";
        }

    }
}
