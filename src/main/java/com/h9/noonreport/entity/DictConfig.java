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
 * 午报字典表
 * </p>
 *
 * @author 9h
 * @since 2023-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_dict_config")
@ApiModel(value="DictConfig对象", description="午报字典表")
public class DictConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "字典代号")
    private String code;

    @ApiModelProperty(value = "1字符,2数字")
    private Integer type;

    @ApiModelProperty(value = "somskey")
    private String collectCode;

    @ApiModelProperty(value = "需要前置计算值为基础")
    private Integer parentId;

    @ApiModelProperty(value = "规则优先级")
    private Integer level;


}
