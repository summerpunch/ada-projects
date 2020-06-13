package com.ada.basic.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 基类
 * </p>
 *
 * @author XiaChong
 * @since 2020-06-10
 */
public class BaseEntity implements Serializable {

    private Long id;

    /**
     * 创建人员
     */
    private Long adminCreate;

    /**
     * 更新人员
     */
    private Long adminUpdate;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


    /**
     * 状态：N 未删除、Y 已经删除
     */
    @TableLogic
    private String isDelete;


}
