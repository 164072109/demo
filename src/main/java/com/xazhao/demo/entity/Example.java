package com.xazhao.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Example implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ex_id", type = IdType.AUTO)
    private Long exId;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    private Long objectVersionNumber;

    private Long createdBy;

    private LocalDateTime creationDate;

    private Long lastUpdatedBy;

    private LocalDateTime lastUpdateDate;


}
