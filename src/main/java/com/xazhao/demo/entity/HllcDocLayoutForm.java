package com.xazhao.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 布局表单配置
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HllcDocLayoutForm implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 第几行
     */
    private Long rowSeq;

    /**
     * 第几列
     */
    private Long columnSeq;

    /**
     * 占几行
     */
    private Long rowCount;

    /**
     * 占几列
     */
    private Long columnCount;

    /**
     * 表单关联字段值
     */
    private String cascadeValue;

    /**
     * 组件主键
     */
    private Long tabId;

    /**
     * 行版本号，用来处理锁
     */
    private Long objectVersionNumber;

    private Long createdBy;

    private LocalDateTime creationDate;

    private Long lastUpdatedBy;

    private LocalDateTime lastUpdateDate;

    /**
     * 字段id
     */
    private Long fieldId;


}
