package com.ada.basic.controller;


import com.ada.basic.entity.dto.BasicDictionaryTreeDTO;
import com.ada.basic.entity.vo.BasicDictionaryTreeVO;
import com.ada.basic.service.IBasicDictionaryService;
import com.ada.common.response.ResponseData;
import com.ada.common.response.ResponseUtil;
import com.ada.common.utils.BeanCopierUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author XiaChong
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/dictionary")
public class BasicDictionaryController {


    private static final Logger LOGGER = LoggerFactory.getLogger(BasicDictionaryController.class);

    @Autowired
    private IBasicDictionaryService service;


    /**
     * Title: 获取数据字典结构树<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/3/1 11:17<br>
     */
    @GetMapping(value = "get/ListByParentCode")
    public ResponseData getListByParentCode(String parentCode) {
        BasicDictionaryTreeDTO dto = service.getListByParentKey(parentCode);
        if (dto == null) {
            return ResponseUtil.success(null);
        }
        BasicDictionaryTreeVO vo = new BasicDictionaryTreeVO();
        BeanCopierUtils.copy(dto, vo);
        return ResponseUtil.success(vo);
    }


}
