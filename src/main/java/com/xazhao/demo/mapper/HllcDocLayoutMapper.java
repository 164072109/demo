package com.xazhao.demo.mapper;

import com.xazhao.demo.entity.HllcDocLayout;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 布局定义 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
public interface HllcDocLayoutMapper extends BaseMapper<HllcDocLayout> {

    HllcDocLayout selectByLayout(@Param("code") String layoutCode);
}
