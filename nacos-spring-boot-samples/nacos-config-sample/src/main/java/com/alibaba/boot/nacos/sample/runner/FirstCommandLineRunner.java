package com.alibaba.boot.nacos.sample.runner;

import com.alibaba.boot.nacos.sample.ConfigApplication;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.common.Constants;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class FirstCommandLineRunner implements CommandLineRunner {

    @NacosInjected
    private ConfigService configService;

    @Override
    public void run(String... args) throws Exception {
        if (configService.publishConfig(ConfigApplication.DATA_ID, Constants.DEFAULT_GROUP, ConfigApplication.content)) {
            Thread.sleep(200);
            System.out.println("First runner success: " + configService
                    .getConfig(ConfigApplication.DATA_ID, Constants.DEFAULT_GROUP, 5000));
        } else {
            System.out.println("First runner error: publish config error");
        }
    }
}
