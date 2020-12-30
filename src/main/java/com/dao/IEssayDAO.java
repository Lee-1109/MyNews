package com.dao;

import com.model.Essay;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 13:56
 * @Version 1.0
 */

public interface IEssayDAO {
    List<Essay> list();

    List<Essay> listByPage(HashMap<String,Object> map);

    List<Essay> listByCondition(HashMap<String,Object> map);

    List<Essay> listByConditionByPage(HashMap<String,Object> map);

    List<Essay> listReview();

    List<Essay> listReviewByPage(HashMap<String,Object> map);

    /**
     * @param map  哈希表 存储要求的参数
     *  要求数据:   essayId 待更新的文章的编号
     *            status 更新的状态
     *            doAdminId 执行操作的管理员Id
     * @return 更新成功返回true 否则返回 false
     */
    boolean updateVerify(HashMap<String,Object> map);

    /**
     * 删除文章的id
     * @param essayId
     * @return
     */
    boolean deleteEssay(String essayId);
}
