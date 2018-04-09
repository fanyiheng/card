package com.bx.card.enums;

public enum QrCodeCardExceptionCode implements Coder<String>{
    SYS_EXP("PSTCD-001","系统异常"),
    FILE_SAVE_EXP("PSTCD-101","文件保存异常"),
            ;
    private String code;
    private String desc;

    QrCodeCardExceptionCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getCode() {
        return code;
    }
}
