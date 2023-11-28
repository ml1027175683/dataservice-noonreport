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
 * 午报计算公式表
 * </p>
 *
 * @author 9h
 * @since 2023-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_rule_config")
@ApiModel(value="RuleConfig对象", description="午报计算公式表")
public class RuleConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "函数名称")
    private String funcName;

    @ApiModelProperty(value = "函数描述")
    private String funcDesc;

    @ApiModelProperty(value = "公式")
    private String formulaBody;

    @ApiModelProperty(value = "groovy执行体")
    private String groovyBody;

    @ApiModelProperty(value = "python执行体")
    private String pythonBody;

    @ApiModelProperty(value = "lua 执行体")
    private String luaBody;

    @ApiModelProperty(value = "处理公式类型, 0 formula,1 groovy,2 python,3 lua")
    private Integer dealType;


}
