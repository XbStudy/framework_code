package com.dl.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dl.mapper.ProductMapper;
import com.dl.pojo.Product;
import com.dl.service.ProductService;
import org.springframework.stereotype.Service;

@DS("slave_1")  // 指定所操作的数据源
@Service
public class ProductServiceImpl  extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
