package com.enjie.controller;
import com.enjie.bean.Test;
import com.enjie.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    TestServiceImpl testServiceImpl;
    @GetMapping("getAll")
    public List<Test> selectAll(){
        List<Test> list = testServiceImpl.selectAll();
    return list;
    }

    @PostMapping("/getClient")
    public Object servicetList(){
        List<String> services = discoveryClient.getServices();
        System.out.println(services);

        //可以通过服务列表信息得到具体的微服务信息(通过微服务名称得到)
        List<ServiceInstance> instances =
                discoveryClient.getInstances("");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+""+
                            instance.getPort()+
                            instance.getUri()+
                            instance.getServiceId()
            );
        }
        return this.discoveryClient;
    }
}
