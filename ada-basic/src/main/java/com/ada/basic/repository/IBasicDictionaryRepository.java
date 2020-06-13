package com.ada.basic.repository;

import com.ada.basic.entity.BasicDictionary;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author XiaChong
 * @since 2020-06-10
 */
public interface IBasicDictionaryRepository extends IService<BasicDictionary> {

    void create(BasicDictionary entity);

    void creates(List<BasicDictionary> entitys);

    void update(BasicDictionary entity);

    void updates(List<BasicDictionary> entitys);

    List<BasicDictionary> getList();

    List<BasicDictionary> getList(QueryWrapper<BasicDictionary> wrapper);

    BasicDictionary getById(Long id);

}
