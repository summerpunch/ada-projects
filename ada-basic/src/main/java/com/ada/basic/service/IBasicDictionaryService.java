package com.ada.basic.service;

import com.ada.basic.entity.BasicDictionary;
import com.ada.basic.entity.dto.BasicDictionaryTreeDTO;
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
public interface IBasicDictionaryService extends IService<BasicDictionary> {

    void create(BasicDictionary entity);

    void creates(List<BasicDictionary> entitys);

    void update(BasicDictionary entity);

    void updates(List<BasicDictionary> entitys);

    /**
     * Title: 根据ID查询数据字典<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/8/7 11:59<br>
     */
    BasicDictionary getById(Integer id);

    /**
     * Title: 根据parentKey查询子节点<br>
     * Description:
     * parentKey
     * flag -> true ，递归所有子节点
     * flag -> false ，当前层级子节点
     * <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/8/7 11:58<br>
     */
    BasicDictionaryTreeDTO getListByParentKey(String parentCode);

}
