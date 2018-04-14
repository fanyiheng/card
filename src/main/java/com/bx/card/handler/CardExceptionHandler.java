package com.bx.card.handler;

import com.bx.card.Result;
import com.bx.card.enums.QrCodeCardExceptionCode;
import com.bx.card.exception.QrCodeCardException;
import com.bx.card.util.ResultUtil;
import com.bx.card.util.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CardExceptionHandler {

    @ExceptionHandler(value = QrCodeCardException.class)
    public Result<String> handleSellException(QrCodeCardException e) {
        return ResultUtil.fail(e.getCode().toString(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<String> handleOtherException(Exception e) {
        log.error("【系统异常】-{}",e);
        return ResultUtil.fail(QrCodeCardExceptionCode.SYS_EXP.getCode(),
                Strings.toString(e.getMessage(), QrCodeCardExceptionCode.SYS_EXP.getDesc()));
    }
}
