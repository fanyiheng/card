package com.bx.card.controller;

import com.bx.card.Result;
import com.bx.card.config.QrCodeConfig;
import com.bx.card.enums.QrCodeCardExceptionCode;
import com.bx.card.exception.QrCodeCardException;
import com.bx.card.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("upload")
@Slf4j
public class FileUploadController {

    @Autowired
    private QrCodeConfig qrCodeConfig;

    @RequestMapping("logo")
    public Result<String> uploadLogo(@RequestParam("file_data") MultipartFile logoMultipartFile) {
        if (logoMultipartFile.isEmpty()) {
            return ResultUtil.fail("文件不能为空");
        }
        String fileName = saveLogoFile(logoMultipartFile);
        return ResultUtil.success(fileName);
    }

    private String saveLogoFile(MultipartFile logoMultipartFile) {
        String fileName = getFileName(logoMultipartFile);
        File logoReposPathFile = new File(qrCodeConfig.getLogoRepository());
        if (!logoReposPathFile.exists())
            logoReposPathFile.mkdirs();
        String logoFullFileName = qrCodeConfig.getLogoRepository() + File.separator + fileName;
        try {
            logoMultipartFile.transferTo(new File(logoFullFileName));
        } catch (IOException e) {
            log.error("【文件上传】logo文件保存异常,{}", e);
            throw new QrCodeCardException(QrCodeCardExceptionCode.FILE_SAVE_EXP);
        }
        return fileName;
    }

    public String getFileName(MultipartFile logoMultipartFile) {
        String originalFilename = logoMultipartFile.getOriginalFilename();
        int lastDotIndex = originalFilename.lastIndexOf(".");
        String ext = ".png";
        if (lastDotIndex > 0) {
            ext = originalFilename.substring(lastDotIndex);
        }
        return UUID.randomUUID().toString() + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ext;
    }
}
