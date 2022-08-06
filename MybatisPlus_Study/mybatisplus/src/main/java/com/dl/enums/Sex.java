package com.dl.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
import lombok.val;

@Getter
public enum Sex {
    MALE("男",1),
    MAN("女",0);

    private String sexName;

    @EnumValue //枚举的值作为
    private Integer sex;

    private Sex(String sexName,Integer sex){
        this.sexName = sexName;
        this.sex = sex;
    }

}
