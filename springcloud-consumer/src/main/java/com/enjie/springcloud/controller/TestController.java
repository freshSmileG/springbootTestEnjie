package com.enjie.springcloud.controller;

import com.enjie.bean.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestController {
    //利用restTemplate来调用接口
    public static final String URL = "http://SPRINGCLOUD-PROVIDER-8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getAll")
    public List<Test> getAll(){
        return (List<Test>) restTemplate.getForObject(URL + "/getAll", List.class);

    }
}
