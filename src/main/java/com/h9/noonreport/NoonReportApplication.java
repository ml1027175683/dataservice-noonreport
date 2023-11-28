package com.h9.noonreport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 应用启动类
 *
 * @author light
 * @date 2023/09/26
 */
@MapperScan("com.zdiai.**.mapper")
@ComponentScan(basePackages = "com.h9.*")
@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableFeignClients
public class NoonReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoonReportApplication.class, args);
    }

}
