package com.xazhao.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.xazhao.demo.entity.HllcDocLayout;
import com.xazhao.demo.service.IHllcDocLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * <p>
 * 布局定义 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@RestController
@RequestMapping()
public class HllcDocLayoutController {

    @Autowired
    private IHllcDocLayoutService hllcDocLayoutService;

    @PostMapping("/export")
    public List<HllcDocLayout> query(@RequestBody List<String> paramList) {
        return hllcDocLayoutService.export(paramList);
    }


    @PostMapping("/importLayout")
    public void importLayout(MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        List<HllcDocLayout> list = JSONObject.parseArray(content, HllcDocLayout.class);
        hllcDocLayoutService.importLayout(list);
    }
}
