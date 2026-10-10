package com.gresidence.residence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gresidence.residence.Services.FileService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/gresidence/residence/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/log")
    public void writeLog(@RequestBody String message) {
        fileService.writeLog(message);
    }
}