package com.dl.mapper;
import org.apache.ibatis.annotations.Param;

import com.dl.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity com.dl.pojo.Product
 */
public interface ProductMapper extends BaseMapper<Product> {

    int insertSelective(Product product);

}




