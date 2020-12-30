package com.service.impl;

import com.dao.ILoginDAO;
import com.model.Admin;
import com.service.ILoginService;

import javax.annotation.Resource;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 15:27
 * @Version 1.0
 */

public class LoginServiceImpl implements ILoginService {

    private ILoginDAO loginDAO;

    public void setLoginDAO(ILoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public boolean validate(Admin admin) {
        Admin admin1 = loginDAO.selectOne(admin.getId());
        if(admin1.equals(admin)){
            System.out.println("====admin:"+admin1.getId()+admin1.getGrants()+"load success!====");
            return true;
        }else {
            System.out.println("====admin:"+admin.getId()+admin.getGrants()+"load error!====");
            return false;
        }
    }

    @Override
    public boolean doLogin(Admin admin) {
        return false;
    }


    @Override
    public boolean doLogout(Admin admin) {
        return false;
    }
}
