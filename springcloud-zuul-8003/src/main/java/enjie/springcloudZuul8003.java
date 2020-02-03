package enjie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class springcloudZuul8003 {
    public static void main(String[] args) {
        SpringApplication.run(springcloudZuul8003.class,args);
    }
}
