package com.soa.serviceregistryanddiscoveryclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceRegistryAndDiscoveryService2Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryAndDiscoveryService2Application.class, args);
    }

}
