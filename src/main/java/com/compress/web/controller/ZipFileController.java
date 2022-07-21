package com.compress.web.controller;

import com.compress.domain.service.ZipFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ZipFileController {

    @Autowired
    private ZipFilesService zipFilesService;

    @PostMapping("/getzip")
    @Scheduled(cron = "0 0 0 ? * 2/2 *")
    public void zipFiles() throws IOException {
        zipFilesService.zipFiles();
    }

}
