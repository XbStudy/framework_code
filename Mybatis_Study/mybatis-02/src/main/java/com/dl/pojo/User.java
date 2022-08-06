package com.dl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("User")
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;

}

