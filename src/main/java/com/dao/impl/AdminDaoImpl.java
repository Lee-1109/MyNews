package com.dao.impl;

import com.dao.IAdminDAO;
import com.model.Admin;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 17:49
 * @Version 1.0
 */

public class AdminDaoImpl extends SqlSessionDaoSupport implements IAdminDAO {

    /**
     * 获取所有管理员
     * @return
     */
    @Override
    public List<Admin> list() {
        List<Admin> admins =  this.getSqlSession().selectList("com.model.Admin.selectList");
        for (Admin admin : admins){
            System.out.println("AdminDaoImpl:"+admin.toString());
        }
        return admins;
    }

    /**
     * 根据页数获取管理员
     * @param map
     * @return
     */
    @Override
    public List<Admin> listByPage(HashMap<String, Object> map) {
        return this.getSqlSession().selectList("com.model.Admin.selectAdminByPage",map);
    }

    @Override
    public List<Admin> listByCondition(HashMap<String,Object> map) {
        return this.getSqlSession().selectList("com.model.Admin.selectByCondition",map);
    }

    @Override
    public List<Admin> listByConditionByPage(HashMap<String, Object> map) {
        List<Admin> admins = this.getSqlSession().selectList("com.model.Admin.selectByConditionByPage",map);
        for (Admin admin : admins){
            System.out.println("AdminDaoImpl.listByConditionByPage"+admin.toString());
        }
        return admins;
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @Override
    public boolean insertAdmin(Admin admin) {
        int type=admin.getGrants();//获取权限
        String using=(type==0)?"insertSuper":(type==1)?"insertAdmin":"insertDefault";
        return (this.getSqlSession().insert("com.model.Admin."+using,admin) != 0);

    }

    /**
     * 删除管理员
     * @param admin
     * @return
     */
    @Override
    public boolean deleteAdmin(Admin admin) {
        String adminId=admin.getId();
        return (this.getSqlSession().delete("com.model.Admin.deleteAdmin",adminId) != 0);
    }

    /**
     * 更新管理员权限
     * @param admin
     * @return
     */
    @Override
    public boolean updateGrant(Admin admin) {
        return this.getSqlSession().update("com.model.Admin.updateGrant",admin) == 1;
    }


}
