package com.service;

import com.model.Admin;
import com.model.Essay;
import com.model.Publish;
import com.model.Reader;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 17:46
 * @Version 1.0
 */

public interface IAdminService {

    /**
     * 授予权限的更改
     * @param admin 管理员信息
     * @param grant 更改后的权限
     * @return 更改成功返回true 否则返回false
     */
    boolean grant(HttpServletRequest request,Admin admin, int grant);

    List<Admin> listAdmin();
    List<Admin> listAdminByCondition(HashMap<String,Object> map);
    List<Admin> listAdminByPage(HashMap<String,Object> map);
    List<Admin> listAdminByConditionByPage(HashMap<String,Object> map);
    List<Reader> listReader();
    List<Reader> listReaderByPage(HashMap<String,Object> map);
    List<Essay> listEssay();
    List<Essay> listEssayByPage(HashMap<String,Object> map);
    List<Publish> listPublish();
    List<Publish> listPublishByPage(HashMap<String,Object> map);



}
