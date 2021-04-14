import org.apache.commons.configuration.DatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import java.sql.DatabaseMetaData;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@ComponentScan(basePackageClasses = DatabaseConfiguration.class)
public class GatewayApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication8003.class,args);
    }
    }
