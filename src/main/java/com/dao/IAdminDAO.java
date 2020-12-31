package com.dao;

import com.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 17:48
 * @Version 1.0
 */

public interface IAdminDAO {
    List<Admin> list();
    List<Admin> listByPage(HashMap<String,Object> map);
    List<Admin> listByCondition(HashMap<String,Object> map);
    List<Admin> listByConditionByPage(HashMap<String,Object> map);
    boolean insert(Admin admin);
    boolean insertList(List<Admin> admins);
    boolean delete(Admin admin);
    boolean deleteList(List<Admin> admins);
    boolean update(Admin admin);
    boolean updateGrant(Admin admin);
}
