package com.dao;

import com.model.Publish;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 11:37
 * @Version 1.0
 */

public interface IPublishDAO {
    List<Publish> list();
    List<Publish> listByPage(HashMap<String,Object> map);
    List<Publish> listByCondition(HashMap<String,Object> map);
    List<Publish> listByConditionByPage(HashMap<String,Object> map);
}
