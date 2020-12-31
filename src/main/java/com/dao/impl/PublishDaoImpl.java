package com.dao.impl;

import com.dao.IPublishDAO;
import com.model.Publish;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 11:38
 * @Version 1.0
 */

public class PublishDaoImpl extends SqlSessionDaoSupport implements IPublishDAO {
    @Override
    public List<Publish> list() {
        List<Publish> publishes =  this.getSqlSession().selectList("com.model.Publish.selectList");
        return publishes;
    }

    @Override
    public List<Publish> listByPage(HashMap<String,Object> map) {
        return this.getSqlSession().selectList("com.model.Publish.selectByPage",map);
    }

    @Override
    public List<Publish> listByCondition(HashMap<String, Object> map) {
        List<Publish> publishes = this.getSqlSession().selectList("com.model.Publish.selectByCondition",map);
        for (Publish publish: publishes) {
            System.out.println("PublishDao_listByCondition:"+publish.toString());
        }
        return this.getSqlSession().selectList("com.model.Publish.selectByCondition",map);
    }

    @Override
    public List<Publish> listByConditionByPage(HashMap<String, Object> map) {
        return this.getSqlSession().selectList("com.model.Publish.selectByConditionByPage",map);
    }
}
