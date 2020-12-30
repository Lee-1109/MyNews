package com.dao.impl;

import com.dao.IEssayDAO;
import com.model.Essay;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 13:57
 * @Version 1.0
 */

public class EssayDaoImpl extends SqlSessionDaoSupport implements IEssayDAO {
    @Override
    public List<Essay> list() {
        List<Essay> essays = this.getSqlSession().selectList("com.model.Essay.selectList");
        for (Essay essay : essays){
            System.out.println("EssayDaoImpl:"+essay.toString());
        }
        return essays;
    }

    @Override
    public List<Essay> listByPage(HashMap<String, Object> map) {
        List<Essay> essays = this.getSqlSession().selectList("com.model.Essay.selectListByPage",map);
        for (Essay essay : essays){
            System.out.println("EssayDaoImpl:"+essay.toString());
        }
        return essays;
    }

    @Override
    public List<Essay> listByCondition(HashMap<String, Object> map) {
        return this.getSqlSession().selectList("com.model.Essay.selectByCondition");
    }

    @Override
    public List<Essay> listByConditionByPage(HashMap<String, Object> map) {
        return this.getSqlSession().selectList("com.model.Essay.selectByConditionByPage");
    }

    @Override
    public List<Essay> listReview() {
        return this.getSqlSession().selectList("com.model.Essay.selectVerifyed");
    }

    @Override
    public List<Essay> listReviewByPage(HashMap<String, Object> map) {
        return this.getSqlSession().selectList("com.model.Essay.listReviewByPage",map);
    }

    @Override
    public boolean updateVerify(HashMap<String, Object> map) {
        return (this.getSqlSession().update("com.model.Essay.updateVerify",map) != 0 );
    }

    @Override
    public boolean deleteEssay(String essayId) {
        return this.getSqlSession().delete("com.model.Essay.deleteOne",essayId) != 0;
    }


}
