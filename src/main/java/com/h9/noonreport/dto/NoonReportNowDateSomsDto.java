package com.h9.noonreport.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class NoonReportNowDateSomsDto implements Serializable {

    @ApiModelProperty(value = "当地时间 yyyy-MM-dd")
    private String localDate;

    @ApiModelProperty(value = "当地时间 yyyy-MM-dd HH:mm:ss")
    private String localTime;

    @ApiModelProperty(value = "当前数据时间戳")
    private Long timestamp;
}
