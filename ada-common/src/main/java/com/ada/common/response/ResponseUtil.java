package com.ada.common.response;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * Title: 请求响应工具类<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2018/8/13 19:18<br>
 */
public class ResponseUtil {

    /**
     * Title: 请求成功，并定制返回消息<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 18:43<br>
     */
    public static ResponseData success(Object data, String msg) {
        return ResponseData.builder().
                code(ResponseCodeEnum.SUCCESS.getCode()).
                msg(msg).
                success(true).
                data(data).
                build();
    }

    /**
     * Title: 请求成功,默认返回消息为 ok<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 18:43<br>
     */
    public static ResponseData success(Object data) {
        return ResponseData.builder().
                code(ResponseCodeEnum.SUCCESS.getCode()).
                msg(ResponseCodeEnum.SUCCESS.getDescribe()).
                success(true).
                data(data).
                build();
    }

    /**
     * Title: 参数校验异常<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 18:43<br>
     */
    public static ResponseData paramInvalidError(String message) {
        if (StringUtils.isBlank(message)) {
            message = ResponseCodeEnum.PARAM_INVALID_ERROR.getDescribe();
        }

        return ResponseData.builder().
                code(ResponseCodeEnum.PARAM_INVALID_ERROR.getCode()).
                msg(message).
                success(false).
                build();
    }

    /**
     * Title: 参数校验异常<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 18:43<br>
     */
    public static ResponseData paramInvalidError(List<FieldError> errors) {
        StringBuilder sb = new StringBuilder();
        if (CollectionUtils.isEmpty(errors)) {
            sb.append(ResponseCodeEnum.PARAM_INVALID_ERROR.getDescribe());
        } else {
            for (FieldError error : errors) {
                sb.append(error.getField());
                sb.append(":");
                sb.append(error.getDefaultMessage());
                sb.append(" ");
            }
        }
        return ResponseData.builder().
                code(ResponseCodeEnum.PARAM_INVALID_ERROR.getCode()).
                msg(sb.toString()).
                success(false).
                build();
    }

}
