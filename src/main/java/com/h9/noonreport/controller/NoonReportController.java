package com.h9.noonreport.controller;


import com.h9.noonreport.service.INoonReportService;
import com.zdiai.general.common.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 午报数据表 前端控制器
 * </p>
 *
 * @author 9h
 * @since 2023-11-15
 */
@RestController
@RequestMapping("/noonreport/noon-report")
public class NoonReportController {
    @Resource
    INoonReportService noonReportService;
    @GetMapping("/getNoonReportById")
    public Result getNoonReportById(Long id) {
       return Result.ok(noonReportService.getNoonReportById(id)) ;
    }
}
