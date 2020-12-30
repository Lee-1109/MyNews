package com.controller;

import com.model.Admin;
import com.model.Essay;
import com.service.IAdminService;
import com.service.IVerifyService;
import com.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 16:21
 * @Version 1.0
 */

//文章审核员控制器

@Controller
public class VerifyController {
    @Resource(description = "adminService")
    private IAdminService adminService;

    @Resource(description = "verifyService")
    private IVerifyService verifyService;

    /**
     * 获取内容审核员需要审的文章列表
     * @param request
     * @param map
     * @return
     */

    @RequestMapping("/adminEssay")
    public String adminEssay(HttpServletRequest request,
                             HashMap<String, Object> map){
        String pageNow=request.getParameter("pageNow");
        if (null == pageNow) pageNow ="1";
        int pageN=Integer.parseInt(pageNow);//获取当前页
        int totalPageCount=adminService.listEssay().size();
        Page page=new Page(totalPageCount,pageN);
        page.setPageSize(5);
        //设置处理的URL
        map.put("url","adminEssay");
        map.put("page",page);
        List<Essay> essays = adminService.listEssayByPage(map);
        map.put("essays",essays);
        return "adminEssay";
    }

    @RequestMapping("/adminEssayReview")
    public String adminReVerifyEssay(HttpServletRequest request, HashMap<String, Object> map){
        String pageNow=request.getParameter("pageNow");
        if (null == pageNow) pageNow ="1";
        int pageN=Integer.parseInt(pageNow);//获取当前页
        int totalPageCount=verifyService.listReview().size();
        Page page=new Page(totalPageCount,pageN);
        page.setPageSize(5);
        map.put("url","adminEssayReview");
        map.put("page",page);
        map.remove("essays");
        List<Essay> essays = verifyService.listReviewByPage(map);
        map.put("essays",essays);
        return "adminEssayReview";
    }

    /**
     *  如果type Review那么就是文章复核
     * @param request
     * @param type
     * @return
     */
    @RequestMapping("/passEssay{type}")
    public String adminVerifyEssay(HttpServletRequest request,@PathVariable("type")String type){
        String aid = request.getParameter("aid");
        Admin admin = (Admin) request.getSession().getAttribute("nowUser");
        HashMap<String,Object> map=new HashMap<>();
        map.put("doAdmin",admin);//将执行操作的管理员放入图中
        map.put("verifyEssay",new Essay(aid));//将更新的文章放入图中
        verifyService.passEssay(map);
        return "redirect:adminEssay"+type;
    }

    @RequestMapping("/unPassEssay")
    public String adminReVerifyEssay(HttpServletRequest request){
        String aid = request.getParameter("aid");
        Admin admin = (Admin) request.getSession().getAttribute("nowUser");
        HashMap<String,Object> map=new HashMap<>();
        map.put("doAdmin",admin);//将执行操作的管理员放入图中
        map.put("verifyEssay",new Essay(aid));//将更新的文章放入图中
        verifyService.unPassEssay(map);
        return "redirect:adminEssay";
    }

    @RequestMapping("/deleteEssay{type}")
    public String adminDeleteEssay(HttpServletRequest request, @PathVariable("type")String type){
        String essayId=request.getParameter("aid");
        if(verifyService.delete(essayId))
        {
            return "redirect:adminEssay"+type;
        }
        else {
            return "error";
        }
    }
}
