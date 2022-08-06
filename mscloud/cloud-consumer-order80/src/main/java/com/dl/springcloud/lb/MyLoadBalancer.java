package com.dl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalancer implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public  ServiceInstance getInstance(List<ServiceInstance> list) {
        int index = getAndIncrement() % list.size();
        return list.get(index);
    }

    private int getAndIncrement() {
        int curr;
        int next;
        do {
            curr = atomicInteger.get();
            next = curr >= Integer.MAX_VALUE ? 0 : curr+1;
        }while (!atomicInteger.compareAndSet(curr,next));
        System.out.println("######## next:  "+next);
        return next;
    }
}
