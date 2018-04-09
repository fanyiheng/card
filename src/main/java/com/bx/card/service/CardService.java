package com.bx.card.service;

import com.bx.card.config.QrCodeConfig;
import com.bx.card.enums.QrCodeCardExceptionCode;
import com.bx.card.exception.QrCodeCardException;
import com.bx.card.form.CardForm;
import com.bx.card.util.QRCodeEncoder;
import com.bx.card.util.Strings;
import com.bx.card.common.util.qrcode.MatrixToBgImageConfig;
import com.bx.card.common.util.qrcode.QrcodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;


@Service
@Slf4j
public class CardService {

    @Autowired
    private QrCodeConfig qrCodeConfig;

    @Autowired
    private QrcodeUtils qrcodeUtils;

    public String genCardOnlyQrcode(CardForm cardForm) {
        //文件名
        String qrCodeFileName = getQrCodeFileName(cardForm);
        //生成二维码
        genQrCode(cardForm, qrCodeFileName);
        //明信片信息和二维码文件名写入日志
        saveQrCodeFile(cardForm, qrCodeFileName);
        return qrCodeFileName;
    }

    private void saveQrCodeFile(CardForm postcardForm, String qrCodeFullFileName) {
        log.info(qrCodeFullFileName + "|" + postcardForm);
    }

    private void genQrCode(CardForm postcardForm, String qrCodeFileName) {
        String qrCodeRepository = qrCodeConfig.getQrCodeRepository();
        File file = new File(qrCodeRepository);
        if (!file.exists()) {
            file.mkdirs();
        }

        String qrCodeFullFileName = qrCodeRepository + File.separator + qrCodeFileName;

        String content = genQrCodeContent(postcardForm);

        QRCodeEncoder encoder = new QRCodeEncoder();

        //加上logo
        if (!Strings.isEmpty(postcardForm.getLogoFileName())) {
            String logoFullFileName = qrCodeConfig.getLogoRepository() + File.separator + postcardForm.getLogoFileName();
            encoder.encoderQRCode(content, qrCodeFullFileName, "png", "utf-8", 5,
                    10, Color.BLACK, Color.WHITE, 4, logoFullFileName, null);
        } else if (!Strings.isEmpty(postcardForm.getShortcutDesc())) {
            //加上备注
            encoder.encoderQRCode(content, qrCodeFullFileName, "png", "utf-8", 5, 30, Color.BLACK, null, 6, null, "", postcardForm.getShortcutDesc(), null, "");
        } else {
            //生成普通二维码：名片
            encoder.encoderQRCode(content, qrCodeFullFileName, "png", "UTF-8", 4, null, null, null, 6, null, null);
        }
    }

    private String genQrCodeContent(CardForm postcardForm) {
        StringBuilder sb = new StringBuilder();
        sb.append("MECARD:N:").append(postcardForm.getUserName()).append(";");
        sb.append("TIL:").append(postcardForm.getJobTitle()).append(";");
        sb.append("TEL:").append(postcardForm.getPhoneNumber()).append(";");
        sb.append("ORG:").append(postcardForm.getOrg()).append(";");
        sb.append("EMAIL:").append(postcardForm.getEmail()).append(";");
        sb.append("ADR:").append(postcardForm.getAddress()).append(";");
        sb.append("URL:").append(postcardForm.getPersonalHomepage()).append(";");
        return sb.toString();
    }

    private String getQrCodeFileName(CardForm postcardForm) {
        String uuid = UUID.randomUUID().toString();
        String qrCodeFile = uuid + Strings.toString(postcardForm.getPhoneNumber());
        return qrCodeFile + ".png";
    }

    public String genCard(CardForm cardForm) {
        //文件名
        String cardFileName = getCardFileName(cardForm);
        //生成二维码
        genCard(cardForm, cardFileName);
        //明信片信息和二维码文件名写入日志
        saveQrCodeFile(cardForm, cardFileName);
        return cardFileName;
    }

    private void genCard(CardForm cardForm, String cardFileName) {
        String qrCodeRepository = qrCodeConfig.getQrCodeRepository();
        File file = new File(qrCodeRepository);
        if (!file.exists()) {
            file.mkdirs();
        }

        String qrCodeFullFileName = qrCodeRepository + File.separator + cardFileName;

        String content = genQrCodeContent(cardForm);
        MatrixToBgImageConfig config = new MatrixToBgImageConfig();
        config.setQrcode_url(content);//TODO 这里可以是URL也可以是文本内容，需修改变量名
        config.setRealname(cardForm.getUserName());
        config.setPhone(cardForm.getPhoneNumber());
        config.setJob(cardForm.getJobTitle());
        config.setAdd(cardForm.getAddress());
        config.setTel(cardForm.getTel());
        config.setFax(cardForm.getEmail());
        config.setOrg(cardForm.getOrg());
        if(StringUtils.isNotEmpty(cardForm.getLogoFileName())){
            config.setHeadimgUrl(cardForm.getLogoFileName());
        }
        byte[] bytes = qrcodeUtils.createQrcode(config);
        File f = new File(qrCodeFullFileName);
        try {
            Files.write(f.toPath(), bytes);
        } catch (IOException e) {
           log.error("【名片生成】写入名片文件异常", e);
           throw new QrCodeCardException(QrCodeCardExceptionCode.FILE_SAVE_EXP);
        }
    }

    private String getCardFileName(CardForm cardForm) {
        String uuid = UUID.randomUUID().toString();
        String qrCodeFile = uuid + Strings.toString(cardForm.getPhoneNumber());
        return qrCodeFile + ".jpg";
    }
}
