package com.util;

import com.model.Admin;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/31 9:27
 * @Version 1.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AdminListVo {
    private List<Admin> adminList;

    public boolean isEmpty(){
        return this.adminList.isEmpty();
    }

}
