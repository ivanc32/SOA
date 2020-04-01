package com.soa.serviceregistryanddiscoveryclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceRegistryAndDiscoveryService1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryAndDiscoveryService1Application.class, args);
    }

}
