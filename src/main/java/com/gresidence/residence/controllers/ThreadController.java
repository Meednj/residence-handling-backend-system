package com.gresidence.residence.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gresidence.residence.Services.ThreadManagerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/gresidence/residence/thread")
@AllArgsConstructor
public class ThreadController {

    private final ThreadManagerService threadManagerService;

    @PostMapping("/run")
    public String runThread() {
        threadManagerService.startLatePaymentThread();
        return "Late payment thread started";
    }
}

