package enjie.controller;

import com.enjie.bean.Test;
import enjie.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
