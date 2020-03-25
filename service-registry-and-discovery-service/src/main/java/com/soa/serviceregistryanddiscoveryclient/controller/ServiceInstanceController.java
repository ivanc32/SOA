package com.soa.serviceregistryanddiscoveryclient.controller;


import com.netflix.discovery.EurekaClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController()
public class ServiceInstanceController {

    private EurekaClient discoveryClient;

    public ServiceInstanceController(@Qualifier("eurekaClient") EurekaClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world from Alice";
    }

    @RequestMapping("/call-bob")
    public String serviceInstancesByApplicationName() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet(this.discoveryClient
                .getNextServerFromEureka("Bob", false)
                .getHomePageUrl());

        CloseableHttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            return EntityUtils.toString(entity) + " through Alice";
        }

        return "";
    }
}
