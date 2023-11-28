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
 * 船舶午报绑定关系表
 * </p>
 *
 * @author 9h
 * @since 2023-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_ship_org_dict")
@ApiModel(value="ShipOrgDict对象", description="船舶午报绑定关系表")
public class ShipOrgDict implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "船舶id号")
    private Long shipId;

    @ApiModelProperty(value = "字典id号")
    private Long dictId;


}
