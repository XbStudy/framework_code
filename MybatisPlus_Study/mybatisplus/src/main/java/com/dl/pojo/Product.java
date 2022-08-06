package com.dl.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName("t_product")
public class Product {
    @TableId
    private Long id;
    @TableField
    private String name;
    @TableField
    private Integer price;
    @TableField
    @Version // 标记为乐观锁的版本号字段
    private Integer version;
}
