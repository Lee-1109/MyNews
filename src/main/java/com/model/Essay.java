package com.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 13:53
 * @Version 1.0
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Essay {
    private String aid;
    private String title;
    private String nid;
    private String publishName;
    private String content;
    private Timestamp postTime;
    private String doAdminName;
    private Timestamp verifyTime;


    public Essay(){}

    public Essay(String aid){
        this.aid = aid;
    }

}
