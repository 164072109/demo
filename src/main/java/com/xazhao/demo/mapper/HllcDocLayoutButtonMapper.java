package com.xazhao.demo.mapper;

import com.xazhao.demo.entity.HllcDocLayoutButton;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 布局按钮配置 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
public interface HllcDocLayoutButtonMapper extends BaseMapper<HllcDocLayoutButton> {

    List<HllcDocLayoutButton> selectByParentId(@Param("parentId") Long tabId);
    List<HllcDocLayoutButton> selectByLayoutId(@Param("parentId") Long tabId);
}
