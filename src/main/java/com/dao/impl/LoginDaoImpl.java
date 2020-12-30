package com.dao.impl;

import com.dao.ILoginDAO;
import com.model.Admin;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 15:15
 * @Version 1.0
 */


public class LoginDaoImpl extends SqlSessionDaoSupport implements ILoginDAO {

    @Override
    public Admin selectOne(String id) {
       return this.getSqlSession().selectOne("com.model.Admin.selectOne",id);
    }
}
