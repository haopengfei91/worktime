package com.faymax.server.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Faymax
 * @Description: 验证码
 */
@Api(tags = "CaptchaController")
@RestController
public class CaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @ApiOperation(value = "验证码", produces = "image/jpeg")
    @GetMapping(value = "/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码开始
        String text = defaultKaptcha.createText();
        System.out.println("验证码内容：" + text); //将验证码放入session中
        request.getSession().setAttribute("captcha", text); //根据文本内容创建图形验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream(); //输出流输出图片，格式jpg
            ImageIO.write(image, "jpg", outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
