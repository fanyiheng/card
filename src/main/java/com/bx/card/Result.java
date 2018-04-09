package com.bx.card;

import lombok.Data;

@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;
}
