package com.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 统一异常处理
     *
     * @param e 异常
     * @return 响应信息
     */
    @ExceptionHandler(value = Exception.class)
    public Object advice(Exception e) {

        log.info("错误信息", e);
        return e.getMessage();

    }

}
