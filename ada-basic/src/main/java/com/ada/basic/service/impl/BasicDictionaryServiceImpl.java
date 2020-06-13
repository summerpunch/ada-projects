package com.ada.basic.service.impl;

import com.ada.basic.entity.BasicDictionary;
import com.ada.basic.entity.dto.BasicDictionaryTreeDTO;
import com.ada.basic.mapper.basic.BasicDictionaryMapper;
import com.ada.basic.repository.IBasicDictionaryRepository;
import com.ada.basic.service.IBasicDictionaryService;
import com.ada.common.enums.YesOrNoEnum;
import com.ada.common.utils.BeanCopierUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author XiaChong
 * @since 2020-06-10
 */
@Service
public class BasicDictionaryServiceImpl extends ServiceImpl<BasicDictionaryMapper, BasicDictionary> implements IBasicDictionaryService {

    private final static String ROOT = "root";


    @Autowired
    private IBasicDictionaryRepository repository;


    @Override
    public void create(BasicDictionary entity) {
        repository.create(entity);
    }

    @Override
    public void creates(List<BasicDictionary> entitys) {
        repository.creates(entitys);
    }

    @Override
    public void update(BasicDictionary entity) {
        repository.update(entity);
    }

    @Override
    public void updates(List<BasicDictionary> entitys) {
        repository.updates(entitys);
    }

    @Override
    public BasicDictionary getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public BasicDictionaryTreeDTO getListByParentKey(String parentCode) {
        List<BasicDictionary> list;
        BasicDictionaryTreeDTO root = new BasicDictionaryTreeDTO();
        Map<String, List<BasicDictionaryTreeDTO>> temp = new HashMap<>();

        QueryWrapper<BasicDictionary> wrapper = new QueryWrapper<>();
        wrapper.eq("status", YesOrNoEnum.Y.getCode());

        if (StringUtils.isBlank(parentCode) || ROOT.equalsIgnoreCase(parentCode)) {
            list = repository.getList(wrapper);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }

            this.analyzeData(list, ROOT, root, temp);
            this.assembleData(root, temp);
        } else {
            wrapper.likeRight(true, "code", parentCode);
            list = repository.getList(wrapper);
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }

            this.analyzeData(list, parentCode, root, temp);
            this.assembleData(root, temp);
        }
        return root;
    }


    private void analyzeData(List<BasicDictionary> list,
                             String code,
                             BasicDictionaryTreeDTO root,
                             Map<String, List<BasicDictionaryTreeDTO>> temp) {
        for (BasicDictionary entity : list) {
            if (StringUtils.isBlank(entity.getParentCode()) && code.equalsIgnoreCase(entity.getCode())
                    || (StringUtils.isNotBlank(code) && code.equalsIgnoreCase(entity.getCode()))) {
                BeanCopierUtils.copy(entity, root);
            } else {
                List<BasicDictionaryTreeDTO> trees = temp.get(entity.getParentCode());
                if (CollectionUtils.isEmpty(trees)) {
                    trees = new ArrayList<>();
                }
                BasicDictionaryTreeDTO rootDto = new BasicDictionaryTreeDTO();
                BeanCopierUtils.copy(entity, rootDto);
                trees.add(rootDto);
                temp.put(entity.getParentCode(), trees);
            }
        }
    }


    /**
     * Title: 递归组装数据<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Date: 2019-12-05 13:30<br>
     */
    private void assembleData(BasicDictionaryTreeDTO root,
                              Map<String, List<BasicDictionaryTreeDTO>> temp) {

        List<BasicDictionaryTreeDTO> children = new ArrayList<>();
        if (MapUtils.isNotEmpty(temp)) {
            List<BasicDictionaryTreeDTO> list = temp.get(root.getCode());
            if (CollectionUtils.isNotEmpty(list)) {
                for (BasicDictionaryTreeDTO entity : list) {
                    assembleData(entity, temp);
                    children.add(entity);
                }
            }
        }
        if (CollectionUtils.isNotEmpty(children)) {
            root.setChildren(children);
        } else {
            root.setChildren(Lists.newArrayList());
        }
    }

}
