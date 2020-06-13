package com.ada.common.response;

/**
 * Title: 接口响应结果code<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2018/8/13 19:04<br>
 */
public enum ResponseCodeEnum {
    /**
     * Title: 成功<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 19:05<br>
     */
    SUCCESS(2000, "OK"),

    /**
     * Title: 错误请求<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2020/6/10 23:23<br>
     */
    REQUEST_ERROR(4000, "REQUEST ERROR"),

    /**
     * Title: 拒绝访问<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 19:07<br>
     */
    UNAUTHORIZED(4003, "UNAUTHORIZED"),

    /**
     * Title: 找不到资源<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 19:08<br>
     */
    UNABLE_FIND_RESOURCES(4004, "UNABLE FIND RESOURCES"),


    /**
     * Title: Service业务错误<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 19:06<br>
     */
    SERVICE_BUSINESS_ERROR(5000, "Service Business Error"),

    /**
     * Title: 参数校验错误<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 19:06<br>
     */
    PARAM_INVALID_ERROR(8001, "Param Invalid Error"),

    /**
     * Title: 空指针<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 19:10<br>
     */
    NULL_POINTER_ERROR(8002, "NULL POINTER ERROR"),

    /**
     * Title: 唯一性校验错误<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2018/8/13 19:12<br>
     */
    UNIQUENESS_ERROR(8003, "UNIQUENESS ERROR");

    private int code;

    private String describe;

    ResponseCodeEnum(int code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
