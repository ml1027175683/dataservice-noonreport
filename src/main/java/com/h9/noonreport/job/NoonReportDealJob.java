package com.h9.noonreport.job;

import com.h9.noonreport.service.INoonReportBaseService;
import com.zdiai.noonreport.service.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NoonReportDealJob {

    @Resource
    INoonReportBaseService baseService;


    @Scheduled(cron = "0 0/5 * * * ?")
    public void dealNoonReport() {
        baseService.dealNoonReport();
    }

    @Scheduled(cron = "0 0 2 * * ?")
    public void deal7daysNoonReport() {

        baseService.deal7daysNoonReport();
    }

}
