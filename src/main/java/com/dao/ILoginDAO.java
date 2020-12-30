package com.dao;
import com.model.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 15:32
 * @Version 1.0
 */

public interface ILoginDAO {

    Admin selectOne(String id);

}
