package com.ada.basic.entity.dto;

import com.ada.basic.entity.BasicDictionary;
import lombok.Data;

import java.util.List;

@Data
public class BasicDictionaryTreeDTO extends BasicDictionary {

    private List<BasicDictionaryTreeDTO> children;

}
