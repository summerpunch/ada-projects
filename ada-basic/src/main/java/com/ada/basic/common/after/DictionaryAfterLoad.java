package com.ada.basic.common.after;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DictionaryAfterLoad {

    private final static Logger LOGGER = LoggerFactory.getLogger(DictionaryAfterLoad.class);

    @PostConstruct
    public void init() {

    }


}
