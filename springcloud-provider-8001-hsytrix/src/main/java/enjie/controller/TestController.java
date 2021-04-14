package enjie.controller;
import com.enjie.bean.Test;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import enjie.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    TestServiceImpl testServiceImpl;
    @GetMapping("getAll")
    @HystrixCommand(fallbackMethod = "hystrixSelectAll")
    public List<Test> selectAll() {
        List<Test> list = testServiceImpl.selectAll();
        if (list == null){
            throw new RuntimeException("数据库无数据");
        }
        return list;
    }
    //selectAll方法不可用时候的备选方案
    public List<Test> hystrixSelectAll() {
        List<Test> list = new ArrayList<>();
        Test test = new Test();
        test.setId("备选方案执行");
        list.add(test);
        return list;
    }
}
