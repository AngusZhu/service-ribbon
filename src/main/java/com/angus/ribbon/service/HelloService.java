package com.angus.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient balancerClient;

    public String sayHello(String name) {
        ServiceInstance sayhelloserver = balancerClient.choose("SAYHELLOSERVER");
        name = name + "[" + sayhelloserver.getHost() + ":" + sayhelloserver.getPort() + "]";
        System.out.println("======" + name);
        return restTemplate.getForObject("http://SAYHELLOSERVER/name/" + name, String.class);
    }


}