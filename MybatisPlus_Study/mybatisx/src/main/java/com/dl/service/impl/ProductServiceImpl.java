package com.dl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dl.pojo.Product;
import com.dl.service.ProductService;
import com.dl.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




