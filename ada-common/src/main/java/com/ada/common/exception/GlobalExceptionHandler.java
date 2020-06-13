package com.ada.common.exception;

import com.ada.common.response.ResponseCodeEnum;
import com.ada.common.response.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


/**
 * Title: 全局异常捕获<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/2/27 17:59<br>
 */
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Title: 空指针异常<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/2/27 17:44<br>
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseData nullPointerExceptionHandler(NullPointerException e) {
        LOGGER.error("nullPointerExceptionHandler", e);
        return ResponseData.builder().
                code(ResponseCodeEnum.NULL_POINTER_ERROR.getCode()).
                msg(e.getMessage()).
                success(false).
                build();
    }

    /**
     * Title: 方法参数校验异常<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/2/27 17:44<br>
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseData methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        LOGGER.error("methodArgumentTypeMismatchException", e);
        return ResponseData.builder().
                code(ResponseCodeEnum.PARAM_INVALID_ERROR.getCode()).
                msg(e.getMessage()).
                success(false).
                build();
    }

    /**
     * Title: 其他异常<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/2/27 17:45<br>
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseData allExceptionHandler(Exception e) {
        LOGGER.error("allExceptionHandler", e);
        return ResponseData.builder().
                code(ResponseCodeEnum.SERVICE_BUSINESS_ERROR.getCode()).
                msg(e.getMessage()).
                success(false).
                build();
    }
}
