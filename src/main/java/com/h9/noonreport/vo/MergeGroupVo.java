package com.h9.noonreport.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 9h
 * @Date: 2023-11-17
 * @Description：
 */
@Data
public class MergeGroupVo implements Serializable {

    @ApiModelProperty("开始下标")
    private Integer startIndex;

    @ApiModelProperty("结束下标")
    private Integer endIndex;

    @ApiModelProperty("时区")
    private Integer timeZone;

}
