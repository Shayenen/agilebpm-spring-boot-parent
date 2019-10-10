package com.dstz.device.core.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public class FileUtils {

    public static byte[] getFileByte(MultipartFile file) throws Exception{
        if (file!=null && !file.isEmpty()){
            InputStream inputStream = file.getInputStream();
            byte[] pictureData = new byte[(int) file.getSize()];
            inputStream.read(pictureData);
           return pictureData;
        }
        return null;
    }
}
