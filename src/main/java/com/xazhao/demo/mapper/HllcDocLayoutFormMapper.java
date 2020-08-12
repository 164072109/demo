package com.xazhao.demo.mapper;

import com.xazhao.demo.entity.HllcDocLayoutForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 布局表单配置 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
public interface HllcDocLayoutFormMapper extends BaseMapper<HllcDocLayoutForm> {

    List<HllcDocLayoutForm> selectByTabId(@Param("tabId") Long tabId);
}
