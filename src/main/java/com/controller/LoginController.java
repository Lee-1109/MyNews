package com.controller;

import com.model.Admin;
import com.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 11:37
 * @Version 1.0
 */

@Controller
public class LoginController {

    @Resource(description = "loginService")
    private ILoginService loginService;

    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request,Admin admin){
        if(null == request.getSession().getAttribute("nowUser")){
            //未登陆执行登陆验证
            if(loginService.validate(admin)){
                HttpSession session = request.getSession();
                admin.setPassword("");
                session.setAttribute("nowUser",admin);
                String grantName=admin.getGrants()==0?"超级管理员":(admin.getGrants()== 1?"系统管理员":"内容审核员");
                session.setAttribute("grantName",grantName);
                return "main";
            }else {
                return "login";
            }
        }else {
            //已经登陆 返回主页
            return "main";
        }

    }

    /**
     * 注销登陆
     * @param request
     * @return
     */
    @RequestMapping("/doLogout")
    public String doLogout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("nowUser");
        return "login";
    }
}
