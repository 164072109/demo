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
 * 布局组件字段定义
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HllcDocLayoutField implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 组件id
     */
    private Long tabId;

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 描述
     */
    private String description;

    /**
     * 类型（字段类型，可选值：boolean number string date dateTime time week month year email url intl object）
     */
    private String dataType;

    /**
     * 输入模式
     */
    private String inputModeDisplay;

    /**
     * 验证类型(文本区域，文本框，货币输入框，数字输入，电子邮件，下拉框，日期选择框，树，单选，复选，开关，lov，超链接)
     */
    private String validationTypeDisplay;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 提示信息
     */
    private String help;

    /**
     * 格式化（可选值: uppercase lowercase capitalize）
     */
    private String format;

    /**
     * 占位词
     */
    private String placeholder;

    /**
     * 是否显示清除按钮
     */
    private String clearButton;

    /**
     * 最小长度
     */
    private Long minLength;

    /**
     * 最大长度
     */
    private Long maxLength;

    /**
     * 正则
     */
    private String pattern;

    /**
     * 限制输入
     */
    private String restrictInput;

    /**
     * 货币代码
     */
    private String currency;

    private String lookupCode;

    /**
     * 选择框值来源
     */
    private Long selectBoxUrl;

    /**
     * 是否展开字段
     */
    private String expandField;

    private String lovCode;

    /**
     * 内部字段别名绑定
     */
    private String bind;

    /**
     * hllc_doc_layouta_field_cascade主键
     */
    private Long cascadeId;

    /**
     * 表单关联标志
     */
    private String formatCascadeFlag;

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
    private Long seq;

    /**
     * 宽度
     */
    private Long width;

    private String isVisible;


    private transient List<HllcDocLayoutFieldCascade> cascadeList;

    private transient List<HllcDocLayoutForm> formList;


}
