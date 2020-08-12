package com.xazhao.demo.mapper;

import com.xazhao.demo.entity.HllcDocLayoutFieldCascade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 组件字段lov级联 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
public interface HllcDocLayoutFieldCascadeMapper extends BaseMapper<HllcDocLayoutFieldCascade> {

    List<HllcDocLayoutFieldCascade> selectByFieldId(@Param("fieldId") Long id);
}
