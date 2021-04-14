package enjie.controller;
import com.enjie.bean.Test;
import enjie.entity.Test1;
import enjie.mapper.TestDao;
import enjie.service.impl.TestServiceImpl;
import enjie.test.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    TestDao testDao;

    @Autowired
    TestServiceImpl testServiceImpl;
    @GetMapping("getAll")
    public List<Test> selectAll(){
        List<Test> list = testServiceImpl.selectAll();
        return list;
    }
    @GetMapping("selectById")
    public Test selectById(Test test){
        Test test1 = testServiceImpl.selectById(test);
        return test1;
    }
    @GetMapping("add")
    public int add(Test1 test){
        List<Test1> list = new ArrayList<>();
        for(int i=0;i<10;++i){
            Test1 test1 = new Test1();
            test1.setId(i+"");
            test1.setName("name"+i);
            list.add(test1);
        }
        int add = testDao.add(list);
        return add;
    }
    @GetMapping("select")
    public List<Map> select(){
        return testDao.select();
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
    @GetMapping("httpClientTest")
    public String httpClientTest(){
        test test = new test();
        return test.httpClientTest();
    }


}

