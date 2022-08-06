package com.dl.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

public class People {
    private String name;
    @Autowired
    @Qualifier("cat1")
    private Cat cat;

    // 如果现实的定义了required属性为false，那么这个对象可以为null，否则不允许为空；required属性的默认值为 true
    @Autowired(required = false)
    @Qualifier("dog1")
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                ", dog=" + dog +
                '}';
    }
}
