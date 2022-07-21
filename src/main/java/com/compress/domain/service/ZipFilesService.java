package com.compress.domain.service;

import com.compress.persistence.ZipFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ZipFilesService {

    @Autowired
    private ZipFile zipFile;

    public void zipFiles() throws IOException {
        zipFile.zipFiles();
    }

}
