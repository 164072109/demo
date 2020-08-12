package com.xazhao.demo.mapper;

import com.xazhao.demo.entity.HllcDocLayoutTab;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 布局组件定义 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
public interface HllcDocLayoutTabMapper extends BaseMapper<HllcDocLayoutTab> {

    List<HllcDocLayoutTab> selectByLayoutId(@Param("layoutId") Long id);
}
