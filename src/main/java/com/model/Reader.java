package com.model;

import lombok.*;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 10:51
 * @Version 1.0
 */

@Setter
@Getter
@EqualsAndHashCode
public class Reader {
    private String uid;
    private String password;
    private String gender;
    private String username;
    private String tel;

    @Override
    public String toString() {
        String string="["+"uid"+uid+"password"+password+"username"+username+"]";
        return string;
    }
}
