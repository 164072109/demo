package com.xazhao.demo.mapper;

import com.xazhao.demo.entity.HllcDocLayoutTabStatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 布局组件嵌入布局状态 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
public interface HllcDocLayoutTabStatusMapper extends BaseMapper<HllcDocLayoutTabStatus> {

    List<HllcDocLayoutTabStatus> selectByTabId(@Param("tabId") Long tabId);
}
