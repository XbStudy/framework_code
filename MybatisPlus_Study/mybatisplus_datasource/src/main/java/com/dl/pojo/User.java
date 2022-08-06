package com.dl.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    @TableLogic
    private Integer isDeleted;

}
