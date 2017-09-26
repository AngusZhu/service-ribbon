package com.angus.ribbon.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="SAYHELLOSERVER")
public interface IHello {


    @RequestMapping(value="/name/{name}",method = RequestMethod.GET)
    public String sayHelloByFeign(@PathVariable(value="name") String name);



}
