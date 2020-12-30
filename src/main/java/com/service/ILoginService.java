package com.service;

import com.model.Admin;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 15:25
 * @Version 1.0
 */

public interface ILoginService {
    boolean validate(Admin admin);
    boolean doLogin(Admin admin);
    boolean doLogout(Admin admin);
}
