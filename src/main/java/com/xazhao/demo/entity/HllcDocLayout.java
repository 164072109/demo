package com.xazhao.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 布局定义
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HllcDocLayout implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
     * 布局code
     */
    private String layoutCode;

    /**
     * 单据类别描述
     */
    private String description;

    /**
     * 是否启用
     */
    private String enableFlag;

    /**
     * 行版本号，用来处理锁
     */
    private Long objectVersionNumber;

    private Long createdBy;

    private LocalDateTime creationDate;

    private Long lastUpdatedBy;

    private LocalDateTime lastUpdateDate;


    private transient List<HllcDocLayoutTab> tabList;

    private transient List<HllcDocLayoutButton> buttonList;
}
