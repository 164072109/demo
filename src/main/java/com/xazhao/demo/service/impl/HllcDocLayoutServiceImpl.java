package com.xazhao.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xazhao.demo.entity.*;
import com.xazhao.demo.mapper.*;
import com.xazhao.demo.service.IHllcDocLayoutService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 布局定义 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-25
 */
@Service
public class HllcDocLayoutServiceImpl extends ServiceImpl<HllcDocLayoutMapper, HllcDocLayout> implements IHllcDocLayoutService {

    @Autowired
    private HllcDocLayoutMapper docLayoutMapper;

    @Autowired
    private HllcDocLayoutTabMapper docLayoutTabMapper;

    @Autowired
    private HllcDocLayoutTabStatusMapper statusMapper;

    @Autowired
    private HllcDocLayoutFieldMapper docLayoutFieldMapper;

    @Autowired
    private HllcDocLayoutFieldCascadeMapper cascadeMapper;

    @Autowired
    private HllcDocLayoutFormMapper formMapper;

    @Autowired
    private HllcDocLayoutButtonMapper buttonMapper;

    @Override
    public List<HllcDocLayout> export(List<String> paramList) {
        List<HllcDocLayout> list = new ArrayList<>();
        for (String layoutCode : paramList) {
            HllcDocLayout docLayout = docLayoutMapper.selectByLayout(layoutCode);
            docLayout.setButtonList(buttonMapper.selectByLayoutId(docLayout.getId()));
            List<HllcDocLayoutTab> tabList = docLayoutTabMapper.selectByLayoutId(docLayout.getId());
            for (HllcDocLayoutTab tab : tabList) {
                Long tabId = tab.getId();
                List<HllcDocLayoutField> fieldList = docLayoutFieldMapper.selectByTabId(tabId);
                for (HllcDocLayoutField field : fieldList) {
                    field.setCascadeList(cascadeMapper.selectByFieldId(field.getId()));
                }
                tab.setFieldList(fieldList);
                String tabType = tab.getTabType();
                if ("Form".equals(tabType)) {
                    List<HllcDocLayoutForm> formList = formMapper.selectByTabId(tabId);
                    Map<Long, List<HllcDocLayoutForm>> map = formList.stream().collect(Collectors.groupingBy(HllcDocLayoutForm::getFieldId));
                    for (HllcDocLayoutField field : fieldList) {
                        field.setFormList(map.get(field.getId()));
                    }
                }
                if ("Table".equals(tabType) || "Form".equals(tabType) || "Tree".equals(tabType)) {
                    tab.setButtonList(buttonMapper.selectByParentId(tabId));
                }
                if ("Layout".equals(tabType)) {
                    tab.setStatusList(statusMapper.selectByTabId(tabId));
                }
            }
            docLayout.setTabList(tabList);
            list.add(docLayout);
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importLayout(List<HllcDocLayout> list) {
        for (HllcDocLayout hllcDocLayout : list) {
            docLayoutMapper.insert(hllcDocLayout);
            Long newLayoutId = hllcDocLayout.getId();
            List<HllcDocLayoutTab> tabList = hllcDocLayout.getTabList();
            for (HllcDocLayoutTab tab : tabList) {
                tab.setLayoutId(newLayoutId);
            }
            tabList = builTree(tabList);
            recursiveSave(tabList);
            List<HllcDocLayoutButton> buttonList = hllcDocLayout.getButtonList();
            if (CollectionUtils.isNotEmpty(buttonList)) {
                for (HllcDocLayoutButton button : buttonList) {
                    button.setParentId(newLayoutId);
                    buttonMapper.insert(button);
                }
            }
        }
    }

    private void recursiveSave(List<HllcDocLayoutTab> tabList) {
        if (CollectionUtils.isNotEmpty(tabList)) {
            for (HllcDocLayoutTab tab : tabList) {
                List<HllcDocLayoutTab> children = tab.getChildren();
                docLayoutTabMapper.insert(tab);
                Long tabId = tab.getId();
                List<HllcDocLayoutField> fieldList = tab.getFieldList();
                if (CollectionUtils.isNotEmpty(fieldList)) {
                    for (HllcDocLayoutField field : fieldList) {
                        field.setTabId(tabId);
                        docLayoutFieldMapper.insert(field);
                        Long fieldId = field.getId();
                        List<HllcDocLayoutForm> formList = field.getFormList();
                        if (CollectionUtils.isNotEmpty(formList)) {
                            for (HllcDocLayoutForm form : formList) {
                                form.setFieldId(fieldId);
                                form.setTabId(tabId);
                                formMapper.insert(form);
                            }
                        }

                        List<HllcDocLayoutFieldCascade> cascadeList = field.getCascadeList();
                        if (CollectionUtils.isNotEmpty(cascadeList)) {
                            for (HllcDocLayoutFieldCascade cascade : cascadeList) {
                                cascade.setFieldId(fieldId);
                                cascadeMapper.insert(cascade);
                            }
                        }
                    }
                }
                List<HllcDocLayoutTabStatus> statusList = tab.getStatusList();
                if (CollectionUtils.isNotEmpty(statusList)) {
                    for (HllcDocLayoutTabStatus status : statusList) {
                        status.setTabId(tabId);
                        statusMapper.insert(status);
                    }
                }
                List<HllcDocLayoutButton> buttonList = tab.getButtonList();

                if (CollectionUtils.isNotEmpty(buttonList)) {
                    for (HllcDocLayoutButton button : buttonList) {
                        button.setParentId(tabId);
                        buttonMapper.insert(button);
                    }
                }


                if (CollectionUtils.isNotEmpty(children)) {
                    for (HllcDocLayoutTab child : children) {
                        child.setParentId(tabId);
                    }
                    recursiveSave(children);
                }
            }
        }
    }

    private List<HllcDocLayoutTab> builTree(List<HllcDocLayoutTab> tabList) {
        List<HllcDocLayoutTab> rootList = tabList.stream().filter(v -> v.getParentId() == null).collect(Collectors.toList());
        for (HllcDocLayoutTab root : rootList) {
            recursiveTree(root, tabList);
        }
        return rootList;
    }

    private void recursiveTree(HllcDocLayoutTab parent, List<HllcDocLayoutTab> tabList) {
        for (HllcDocLayoutTab tab : tabList) {
            if (Objects.equals(tab.getParentId(), parent.getId())) {
                recursiveTree(tab, tabList);
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(tab);
            }
        }
    }


}
