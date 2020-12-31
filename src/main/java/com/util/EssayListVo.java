package com.util;

import com.model.Essay;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/30 10:52
 * @Version 1.0
 */
@Getter
@Setter
public class EssayListVo implements Serializable {
    private List<Essay> essayList;

    public EssayListVo() {this.essayList=new ArrayList<>(); }

    boolean isEmpty(){
        return essayList.isEmpty();
    }
}
