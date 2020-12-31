package com.dao.impl;

import com.dao.IReaderDAO;
import com.model.Reader;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 10:58
 * @Version 1.0
 */

public class ReaderDaoImpl extends SqlSessionDaoSupport implements IReaderDAO {
    @Override
    public List<Reader> list() {
        List<Reader> readers = this.getSqlSession().selectList("com.model.Reader.selectList");
        return readers;
    }

    @Override
    public List<Reader> listByPage(HashMap<String, Object> map) {
        List<Reader> readers = this.getSqlSession().selectList("com.model.Reader.selectListByPage",map);
        return readers;
    }

    @Override
    public List<Reader> listByCondition(HashMap<String, Object> map) {
        return this.getSqlSession().selectList("com.model.Reader.selectByCondition",map);
    }

    @Override
    public List<Reader> listByConditionByPage(HashMap<String, Object> map) {
        return this.getSqlSession().selectList("com.model.Reader.selectByConditionByPage",map);
    }
}
