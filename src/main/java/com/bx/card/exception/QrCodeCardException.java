package com.bx.card.exception;

import com.bx.card.enums.Coder;

public class QrCodeCardException extends RuntimeException implements Coder<Object> {

    private Coder<?> coder;
    public QrCodeCardException(Coder<?> coder){
        this.coder = coder;
    }

    @Override
    public String getDesc() {
        return coder.getDesc();
    }

    @Override
    public Object getCode() {
        return coder.getCode();
    }
}
