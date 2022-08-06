package com.dl.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.dl.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

    // 将属性所对应的字段设置为主键：value-字段名
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("email")
    private String email;

    private Sex sex;

    /**
     * 逻辑删除：添加了这个注解那么删除操作就变成了修改操作，修改的是逻辑字段的值
     *          查询操作只会查询逻辑删除为未删除的记录
     */
    @TableLogic
    private Integer isDeleted;

}
