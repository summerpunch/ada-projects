package com.ada.common.utils;

import net.sf.cglib.beans.BeanCopier;

/**
 * Title: BeanCopier工具类<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2020/6/11 13:09<br>
 */
public class BeanCopierUtils {

    /**
     * Title: 将source对象的属性拷贝到target对象中去 <br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2020/6/11 13:10<br>
     */
    public static void copy(Object source, Object target) {
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target, null);
    }


}  
