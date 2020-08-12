package com.xazhao.demo.service;

import com.xazhao.demo.entity.HllcDocLayout;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 布局定义 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
public interface IHllcDocLayoutService extends IService<HllcDocLayout> {

    List<HllcDocLayout> export(List<String> paramList);

    void importLayout(List<HllcDocLayout> list);
}
