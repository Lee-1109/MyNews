package com.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/28 21:07
 * @Version 1.0
 */
@Setter
@Getter
@EqualsAndHashCode
public class Publish {
        private String nid;
        private String password;
        private String name;
        private String address;

        @Override
        public String toString() {
                return "[name="+name+"address:"+address+"]";
        }
}
