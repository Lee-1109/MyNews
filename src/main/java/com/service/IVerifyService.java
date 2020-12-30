package com.service;

import com.model.Essay;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/30 12:24
 * @Version 1.0
 */

public interface IVerifyService {
    /**
     * 需要传入参数：
     * key:doAdmin type:Admin 执行操作的管理员实例
     * key:verifyEssay type:Essay 执行审核的文章
     * @param map
     * @return
     */
    boolean passEssay(HashMap<String,Object> map);
    //不允许通过文章
    boolean unPassEssay(HashMap<String,Object> map);

    List<Essay> listReview();

    List<Essay> listReviewByPage(HashMap<String,Object> map);

    boolean delete(String essayId);
}
