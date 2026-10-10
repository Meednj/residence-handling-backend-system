package com.gresidence.residence.Services;

import org.springframework.stereotype.Service;

import com.gresidence.residence.Threading.LatePaymentRunnable;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ThreadManagerServiceImpl implements ThreadManagerService{

    private final PaymentService paymentService;
    private final FileService fileService;

    public void startLatePaymentThread() {
        Thread thread = new Thread(
            new LatePaymentRunnable(paymentService, fileService)
        );
        thread.start();
    }
}
