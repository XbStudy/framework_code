package com.dl.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MybatisPlusAutoGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "root")
                .globalConfig(builder -> {
                    builder.author("dl") // 设置作者
                            // .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\genetator_test"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.dl") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            // 生成sevice entity controller 都会放在 父包名.父模块名下
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E:\\genetator_test\\com\\dl\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user","t_product") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
