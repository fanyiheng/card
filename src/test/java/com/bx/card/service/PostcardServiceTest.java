package com.bx.card.service;

import com.bx.card.form.CardForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostcardServiceTest {

    @Autowired
    private CardService postcardService;

    @Test
    public void genPostcard() {
        CardForm postcardForm = new CardForm();
        postcardForm.setUserName("陈主任");
        postcardForm.setAddress("深圳龙岗");
        postcardForm.setPhoneNumber("13530436637");
        postcardForm.setOrg("星火");
        postcardForm.setPersonalHomepage("http://www.baidu.com");
        postcardForm.setJobTitle("java 开发工程师");
        postcardForm.setEmail("821679967@qq.com");
        postcardForm.setLogoFileName("20180330090950.jpg");
        String postcard = postcardService.genCardOnlyQrcode(postcardForm);
        System.out.println(postcard);
    }
}
