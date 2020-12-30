package com.interceptor;

import com.model.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/20 19:22
 * @Version 1.0
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {
    //在每次跳转执行前进行拦截 确定用户的的登陆状态
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin = (Admin) request.getSession().getAttribute("nowUser");
        if(null == admin){
            System.out.println("拦截了");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else {
            System.out.println("没拦截");
            //登陆成功 不拦截
        return true;
        }

    }
}
