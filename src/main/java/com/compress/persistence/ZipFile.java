package com.compress.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.time.LocalDate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Repository
@RequestMapping("/")
public class ZipFile {

    private final File PATH = new File("C:\\Users\\Administrador\\Desktop\\toCompress");

    private final File[] FILES = PATH.listFiles();

    public void zipFiles() throws IOException {

        // creo el archivo donde se guardaran los archivos
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrador\\Desktop\\compressed " + LocalDate.now() + ".zip");

        // convierto el archivo donde se guardan los archivos a un zip
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        assert this.FILES != null;
        for (File file : this.FILES) {
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();

    }
}

