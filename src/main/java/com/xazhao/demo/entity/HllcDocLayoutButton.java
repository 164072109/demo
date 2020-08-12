package com.xazhao.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 布局按钮配置
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HllcDocLayoutButton implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 按钮名称
     */
    private String name;

    /**
     * 按钮描述
     */
    private String description;

    /**
     * 类型（组件级/布局级）
     */
    private String type;

    /**
     * 关联id
     */
    private Long parentId;

    /**
     * 行版本号，用来处理锁
     */
    private Long objectVersionNumber;

    private Long createdBy;

    private LocalDateTime creationDate;

    private Long lastUpdatedBy;

    private LocalDateTime lastUpdateDate;

    /**
     * 排序
     */
    private Long orderNum;

    /**
     * 按钮显示类型
     */
    private String buttonShowType;

    /**
     * 按钮显示条件
     */
    private String buttonShowCondition;


}
