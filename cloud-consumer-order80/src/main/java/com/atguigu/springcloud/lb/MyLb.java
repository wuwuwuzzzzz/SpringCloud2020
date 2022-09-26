package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wxz
 * @Date: 2022/9/19 16:47
 */
@Component
public class MyLb implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * @Title: getAutoincrement
     * @Description:
     * @return: int返回类型
     * @Author: wxz
     * @Date: 2022/9/20 10:43
     */
    public final int getAutoincrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
            System.out.println("next:" + next);
            return next;
    }

    /**
     * @Title: instances
     * @Description:  rest接口第几次请求数 % 服务器集群总数量 = 实际服务器下标位置,每次服务器重启后rest接口计数从一开始
     * @Param: serviceInstances
     * @return: ServiceInstance返回类型
     * @Author: wxz
     * @Date: 2022/9/20 10:43
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAutoincrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
