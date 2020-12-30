package com.model;

import lombok.*;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 15:07
 * @Version 1.0
 */

@Setter
@Getter

public class Admin {
    private String id;
    private String password;
    private int grants;

    @Override
    public String toString() {
        return "AdminVo:   id:"+id+"grants"+grants;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Admin){
            Admin admin= (Admin) obj;
            return (admin.getId().equals(this.id))&& admin.getGrants() == this.grants && admin.getPassword().equals(this.password);
        }else {
            return false;
        }
    }
}
