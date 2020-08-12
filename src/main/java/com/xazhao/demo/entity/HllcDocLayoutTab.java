package com.xazhao.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

/**
 * <p>
 * 布局组件定义
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HllcDocLayoutTab implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 布局id
     */
    private Long layoutId;

    /**
     * 父级布局组件id
     */
    private Long parentId;

    /**
     * 组件代码
     */
    private String tabCode;

    /**
     * 布局类型（横向布局，纵向布局，标签页，导航栏）组件类型（表单，表格，树），嵌入布局
     */
    private String tabType;

    /**
     * 顺序
     */
    private Long seq;

    /**
     * 基表
     */
    private String baseTable;

    /**
     * 父基表
     */
    private String parentTable;

    /**
     * 查询url
     */
    private String readUrl;

    /**
     * 创建url
     */
    private String createUrl;

    /**
     * 修改url
     */
    private String updateUrl;

    /**
     * 删除url
     */
    private String destroyUrl;

    /**
     * 行数
     */
    private Long rowCount;

    /**
     * 列数
     */
    private Long columnCount;

    /**
     * 查询组件
     */
    private String queryTabCode;

    /**
     * 父级字段
     */
    private String parentField;

    /**
     * 是否展示
     */
    private String expandField;

    /**
     * 主键字段
     */
    private String primaryKey;

    /**
     * 行版本号，用来处理锁
     */
    private Long objectVersionNumber;

    private Long createdBy;

    private LocalDateTime creationDate;

    private Long lastUpdatedBy;

    private LocalDateTime lastUpdateDate;

    /**
     * 嵌入组件状态key
     */
    private String tabStatusKey;

    /**
     * 组件描述
     */
    private String description;

    /**
     * 删除后校验服务api
     */
    private String deletedCheckApi;

    /**
     * 保存后校验服务api
     */
    private String savedCheckApi;

    /**
     * 基表服务名
     */
    private String serverName;

    /**
     * 变更查询api
     */
    private String changeQueryApi;

    /**
     * 变更主键
     */
    private String changePrimaryKey;

    /**
     * 变更主键
     */
    private String compareField;

    /**
     * 是否展示折叠按钮
     */
    private String showFold;

    /**
     * 默认折叠状态
     */
    private String defaultFold;

    /**
     * 是否启用
     */
    private Boolean enableFlag;

    private transient List<HllcDocLayoutField> fieldList;

    private transient List<HllcDocLayoutForm> formList;

    private transient List<HllcDocLayoutButton> buttonList;

    private transient List<HllcDocLayoutTabStatus> statusList;

    private transient List<HllcDocLayoutTab> children;


}
