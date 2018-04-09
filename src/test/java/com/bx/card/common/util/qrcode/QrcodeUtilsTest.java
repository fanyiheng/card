package com.bx.card.common.util.qrcode;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class QrcodeUtilsTest {

    @Autowired
    private QrcodeUtils qrcodeUtils;

    @Test
    public void testCreateQrcodeMatrixToBgImageConfig() throws IOException {
        MatrixToBgImageConfig config = new MatrixToBgImageConfig();

//        config.setHeadimgUrl("https://avatars2.githubusercontent.com/u/6011374?v=4&u=7672049c1213f7663b79583d727e95ee739010ec&s=400");
//        config.setHeadimgUrl("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3712874477,1757517744&fm=173&app=12&f=JPG?w=218&h=146&s=1CE74A966C35298E5FA396F10300502D");


        StringBuilder sb = new StringBuilder();
        sb.append("MECARD:N:").append("范以恒").append(";");
        sb.append("TIL:").append("java开发工程师").append(";");
        sb.append("TEL:").append("15521321245").append(";");
        sb.append("ORG:").append("星火电子工程公司").append(";");
        sb.append("EMAIL:").append("fanyiheng2018@163.com").append(";");
        sb.append("ADR:").append("深圳龙岗").append(";");
        sb.append("URL:").append("www.baidu.com").append(";");

//        config.setQrcode_url("http://blog.csdn.net/qing_gee");
        config.setQrcode_url(sb.toString());

        config.setRealname("进击的男人");

        config.setPhone("15521321245");
        config.setJob("java开发工程师");
        config.setAdd("深圳龙岗爱联");
        config.setTel("0660-8569548");
        config.setFax("fanyiheng@163.com");


        byte[] bytes = qrcodeUtils.createQrcode(config);
//        Path path = Files.createTempFile("qrcode_with_bg_", ".jpg");
//        Path path = Files.
        File f = new File("D://qrcode_with_bg_.jpg");
        Files.write(f.toPath(), bytes);
    }

}
