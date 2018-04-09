package com.bx.card.service;

import com.bx.card.form.CardForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CardServiceTest {

    @Autowired
    private CardService cardService;

    @Test
    public void genCard() {
        CardForm cardForm = new CardForm();
        cardForm.setAddress("深圳龙岗");
        cardForm.setEmail("fanyiheng2018@163.com");
        cardForm.setJobTitle("java开发工程师");
        cardForm.setOrg("星火工程公司");
        cardForm.setPersonalHomepage("www.baidu.com");
        cardForm.setUserName("范以恒");
        cardForm.setPhoneNumber("15521321245");

        cardService.genCard(cardForm);
    }
}
