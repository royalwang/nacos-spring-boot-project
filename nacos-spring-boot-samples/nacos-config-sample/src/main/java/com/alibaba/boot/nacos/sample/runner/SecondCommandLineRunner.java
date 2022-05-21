package com.alibaba.boot.nacos.sample.runner;

import com.alibaba.boot.nacos.sample.nacosconfig.Foo;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class SecondCommandLineRunner implements CommandLineRunner {

    @NacosValue("${dept:unknown}")
    private String dept;

    @NacosValue("${group:unknown}")
    private String group;

    @Autowired
    private Foo foo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Second runner. dept: " + dept + ", group: " + group);
        System.out.println("Second runner. foo: " + foo);
    }
}
