package com.ada.basic.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author XiaChong
 * @since 2020-06-10
 */
@Getter
@Setter
@ToString
public class BasicDictionary extends BaseEntity {

    /**
     * 字典唯一key
     */
    private String code;

    /**
     * 父节点key
     */
    private String parentCode;

    /**
     * 字典值，一般用于配置项对应的值
     */
    private String value;

    /**
     * 字典中文名称
     */
    private String name;

    /**
     * 状态：启用、禁用
     */
    private String status;

    /**
     * 备注：具体用途细节等
     */
    private String description;

}
