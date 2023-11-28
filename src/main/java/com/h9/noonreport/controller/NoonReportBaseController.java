package com.h9.noonreport.controller;

import com.h9.noonreport.service.INoonReportBaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/base")
public class NoonReportBaseController {
    @Resource
    INoonReportBaseService baseService;

    @GetMapping("/delNoonReport")
    public void delNoonReport() {
        baseService.dealNoonReport();
    }

    @GetMapping("/deal7daysNoonReport")
    public void deal7daysNoonReport() {
        baseService.deal7daysNoonReport();
    }
    @GetMapping("/dealNoonReportByTimestamp")
    public void dealNoonReportByTimestamp(@RequestParam("timestamp")Long timestamp, @RequestParam("shipCode")String shipCode) {
        baseService.dealNoonReport(timestamp,shipCode);
    }

}
