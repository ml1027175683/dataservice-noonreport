package com.h9.noonreport.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 午报数据表
 * </p>
 *
 * @author 9h
 * @since 2023-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_noon_report")
@ApiModel(value="NoonReport对象", description="午报数据表")
public class NoonReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "shipCode")
    private String shipCode;

    @ApiModelProperty(value = "午报数据")
    private String reportMsg;

    @ApiModelProperty(value = "午报开始时间戳")
    private Long startTimestamp;

    @ApiModelProperty(value = "午报结束时间戳")
    private Long endTimestamp;

    @ApiModelProperty(value = "午报时间")
    private String reportDate;


    @ApiModelProperty(value = "时区")
    private String timeZone;

    @ApiModelProperty(value = "创建时间")
    private Date ctime;


}
