package com.bx.card.controller;

import com.bx.card.Result;
import com.bx.card.form.CardForm;
import com.bx.card.service.CardService;
import com.bx.card.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("card")
public class QrCodeCardController {

    @Autowired
    private CardService cardService;

    @PostMapping("gen/qrcode_only")
    public Result<String> genQrcodeOnly(@Valid CardForm cardForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           return ResultUtil.fail(bindingResult.getFieldError().getDefaultMessage());
        }

        String cardFileName = cardService.genCardOnlyQrcode(cardForm);

        return ResultUtil.success(cardFileName,"恭喜！您的名片二维码已制作完成！");
    }

    @PostMapping("gen")
    public Result<String> genCard(@Valid CardForm cardForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           return ResultUtil.fail(bindingResult.getFieldError().getDefaultMessage());
        }

        String cardFileName = cardService.genCard(cardForm);

        return ResultUtil.success(cardFileName,"恭喜！您的名片已制作完成！");
    }
}
