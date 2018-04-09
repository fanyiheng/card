package com.bx.card.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CardForm {
    @NotEmpty
    @Size(max = 32)
    private String userName;
    @NotEmpty
    @Size(max = 16)
    private String phoneNumber;
    private String email;
    private String address;
    private String org;
    private String personalHomepage;
    private String jobTitle;
    private String logoFileName;
    private String shortcutDesc;
    private String tel;
}
