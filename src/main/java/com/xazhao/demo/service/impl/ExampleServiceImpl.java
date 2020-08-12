package com.xazhao.demo.service.impl;

import com.xazhao.demo.entity.Example;
import com.xazhao.demo.mapper.ExampleMapper;
import com.xazhao.demo.service.IExampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@Service
public class ExampleServiceImpl extends ServiceImpl<ExampleMapper, Example> implements IExampleService {

}
