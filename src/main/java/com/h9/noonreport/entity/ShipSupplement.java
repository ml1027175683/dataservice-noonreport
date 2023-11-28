package com.h9.noonreport.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 9h
 * @since 2023-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_ship_supplement")
@ApiModel(value="ShipSupplement对象", description="")
public class ShipSupplement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "shipCode")
    private String shipCode;

    @ApiModelProperty(value = "午报名字")
    private String noonreportKey;

    @ApiModelProperty(value = "午报key值")
    private String noonreportValue;

    @ApiModelProperty(value = "描述")
    private String description;


}
