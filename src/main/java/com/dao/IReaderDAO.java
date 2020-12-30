package com.dao;

import com.model.Reader;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 10:58
 * @Version 1.0
 */

public interface IReaderDAO {
    List<Reader> list();
    List<Reader> listByPage(HashMap<String,Object> map);
    List<Reader> listByCondition(HashMap<String,Object> map);
    List<Reader> listByConditionByPage(HashMap<String,Object> map);
}
