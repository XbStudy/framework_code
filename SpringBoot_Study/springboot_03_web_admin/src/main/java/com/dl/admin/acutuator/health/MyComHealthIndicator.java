package com.dl.admin.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 自定义我们的健康指标信息:
 * 参考DiskSpaceHealthIndicator类
 *    创建我们自己的类,类名后缀一定要是HealthIndicator
 *    并继承AbstractHealthIndicator类
 *    给这个类添加@Component
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    /**
     * 真实的检查方法:
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        if (1 == 1) {
            // builder.up();
            builder.status(Status.UP);
            map.put("count",1);
        }else {
            builder.down();
            map.put("count",0);
        }
        builder.withDetail("msg","xxx").withDetails(map);
    }

}
