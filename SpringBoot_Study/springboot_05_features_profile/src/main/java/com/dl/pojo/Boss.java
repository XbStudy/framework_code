package com.dl.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


/**
 * @Profile("xxx") :
 * 加在类上:在指定的环境下这个类才会生效:
 * 加在属性上:在指定的环境下这个属性才会生效:
 */
//@Profile("test")
@Component
@ConfigurationProperties("person")
public class Boss implements Person {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
