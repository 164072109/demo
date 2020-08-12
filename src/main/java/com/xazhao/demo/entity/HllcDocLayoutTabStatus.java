package com.xazhao.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 布局组件嵌入布局状态
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HllcDocLayoutTabStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 组件id
     */
    private Long tabId;

    /**
     * 布局状态
     */
    private String status;

    /**
     * 类型（配置布局/静态布局）
     */
    private String type;

    /**
     * 嵌入布局id
     */
    private Long layoutId;

    /**
     * 行版本号，用来处理锁
     */
    private Long objectVersionNumber;

    private Long createdBy;

    private LocalDateTime creationDate;

    private Long lastUpdatedBy;

    private LocalDateTime lastUpdateDate;


}
