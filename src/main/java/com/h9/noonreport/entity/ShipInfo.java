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
 * 午报服务船舶表
 * </p>
 *
 * @author 9h
 * @since 2023-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_ship_info")
@ApiModel(value="ShipInfo对象", description="午报服务船舶表")
public class ShipInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "shipCode")
    private String shipCode;

    @ApiModelProperty(value = "船舶中文名字")
    private String shipNameZh;

    @ApiModelProperty(value = "是否启用(0启动,1未启用)")
    private String isEnable;


}
