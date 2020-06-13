package com.ada.basic.repository.impl;

import com.ada.basic.entity.BasicDictionary;
import com.ada.basic.mapper.basic.BasicDictionaryMapper;
import com.ada.basic.repository.IBasicDictionaryRepository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author XiaChong
 * @since 2020-06-10
 */
@Repository
public class BasicDictionaryRepositoryImpl extends ServiceImpl<BasicDictionaryMapper, BasicDictionary> implements IBasicDictionaryRepository {

    @Autowired
    private BasicDictionaryMapper mapper;


    @Override
    public void create(BasicDictionary entity) {
        this.save(entity);
    }

    @Override
    public void creates(List<BasicDictionary> entitys) {
        this.saveBatch(entitys, 100);
    }

    @Override
    public void update(BasicDictionary entity) {
        this.update(entity);
    }

    @Override
    public void updates(List<BasicDictionary> entitys) {
        this.updates(entitys);
    }

    @Override
    public List<BasicDictionary> getList() {
        return this.list();
    }

    @Override
    public List<BasicDictionary> getList(QueryWrapper<BasicDictionary> wrapper) {
        if (wrapper == null) {
            return getList();
        }
        return this.list(wrapper);
    }

    @Override
    public BasicDictionary getById(Long id) {
        return this.getById(id);
    }


}
