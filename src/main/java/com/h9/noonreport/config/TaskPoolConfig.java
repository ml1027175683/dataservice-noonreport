package com.h9.noonreport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


/**
 * 线程池管理
 *
 * @author light
 * @date 2023/09/26
 */
@Configuration
@EnableAsync
public class TaskPoolConfig {

    @Bean("noonReportDealTaskExecutor")
    public Executor noonReportDealTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(50);
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setQueueCapacity(200);
        taskExecutor.setKeepAliveSeconds(100);
        taskExecutor.setThreadNamePrefix("noonReportDealTaskExecutor--");
        taskExecutor.setWaitForTasksToCompleteOnShutdown(false);
        return taskExecutor;
    }

}
