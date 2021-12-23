package com.oocl.moviescombine.controller;

import com.oocl.moviescombine.entity.QRCodeGenerator;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import com.google.zxing.WriterException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/qrcode")
public class QrCodeController {
    @GetMapping(produces = "image/png")
    public @ResponseBody byte[] getQRCode(@RequestParam String url) throws IOException {
        byte[] image = new byte[0];
        try {
            image = QRCodeGenerator.getQRCodeImage(url,300,300);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
