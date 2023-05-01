package com.group.ewaste.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
    public class DataService {

    public void createDir(String email) {
        String filepath = System.getProperty("user.dir") + "/src/main/resources/file" + "/" + email;
        File file = new File(filepath);
        if (file.exists() == false) {
            file.mkdirs();
        }
    }

    public void saveFile(MultipartFile file, String email) throws Exception {
        createDir(email);

        String filename = file.getOriginalFilename();
        String newname = UUID.randomUUID().toString().replace("-", "") + filename.substring(filename.lastIndexOf("."));
        String path = System.getProperty("user.dir") + "/src/main/resources/file" + "/" + email;
        File newpath = new File(path);
        if (!newpath.exists()) newpath.mkdir();
        try {
            File newfile = new File(newpath, newname);
            file.transferTo(newfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File sourceFile = new File(System.getProperty("user.dir") + "/src/main/resources/file" + "/" + email);
        fileToZip(sourceFile);
    }


    public static void fileToZip(String sourceFilePath) throws Exception {
        fileToZip(new File(sourceFilePath));
    }

    public static void fileToZip(File sourceFile) throws Exception {

        if (!sourceFile.exists()) {
            throw new RuntimeException("not existed");
        }
        if (!sourceFile.isDirectory()) {
            throw new RuntimeException("wrong type");
        }
        File zipFile = new File(sourceFile.getAbsolutePath() + ".zip");
        FileOutputStream fos = new FileOutputStream(zipFile);
        ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(fos));
        fileToZip(zos, sourceFile, "");
        zos.close();
        fos.close();
    }


    private static void fileToZip(ZipOutputStream zos, File sourceFile, String path) throws Exception {

        System.out.println(sourceFile.getAbsolutePath());

        if (sourceFile.isDirectory()) {
            path = path + sourceFile.getName() + "/";
            ZipEntry zipEntry = new ZipEntry(path);
            zos.putNextEntry(zipEntry);
            for (File file : sourceFile.listFiles()) {
                fileToZip(zos, file, path);
            }
        } else {
            ZipEntry zipEntry = new ZipEntry(path + sourceFile.getName());
            zos.putNextEntry(zipEntry);
            byte[] bufs = new byte[1024 * 10];

            FileInputStream fis = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fis, 1024 * 10);
            int read = 0;
            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                zos.write(bufs, 0, read);
            }
            bis.close();
            fis.close();
        }
    }

}

