package com.roachfu.solar.app.controller.base;

import com.roachfu.solar.client.base.entity.APIResponse;
import com.roachfu.solar.client.base.entity.Meta;
import com.roachfu.solar.client.base.eums.ErrorEnum;
import com.roachfu.solar.client.base.exception.ApplicationException;
import com.roachfu.solar.client.base.exception.URLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 基础控制器
 *
 * @author roach
 * @date 17/08/2017 22:19
 */
public class BaseController {

    private Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 500 - Internal Server Error
     */
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public APIResponse handleException(Exception e) {
        logger.error("something error : ", e);
        Meta meta = new Meta(ErrorEnum.ERROR);
        return new APIResponse(meta, null);
    }

    /**
     * 404- Bad Parameters
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(URLException.class)
    public APIResponse handleURLException(URLException e) {
        Meta meta = new Meta(404, "The requested resource is not available.");
        return new APIResponse(meta, null);
    }

    /**
     * 400 - 请求参数有误
     */
    //	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public APIResponse handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult br = ex.getBindingResult();
        Meta meta = new Meta();
        meta.setCode(2000);
        meta.setMsg(br.getFieldError().getDefaultMessage());
        return new APIResponse(meta, null);
    }

    /**
     * 400 - 请求参数有误
     */
    //	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public APIResponse handleHttpMessageNotReadableException() {
        Meta meta = new Meta(400, "Required request body is missing");
        return new APIResponse(meta, null);
    }

    /**
     * 406 - 服务端逻辑错误
     */
//	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(ApplicationException.class)
    public APIResponse handleLogicalException(ApplicationException e) {
        Meta meta = new Meta(e.getCode(), e.getMessage());
        return new APIResponse(meta, null);
    }

}
