package com.gresidence.residence.Threading;

import com.gresidence.residence.Services.PaymentService;
import com.gresidence.residence.Dto.PaymentResponseDTO;
import com.gresidence.residence.Services.FileService;

import java.time.LocalDateTime;
import java.util.List;

public class LatePaymentRunnable implements Runnable {

    private final PaymentService paymentService;
    private final FileService fileService;

    public LatePaymentRunnable(PaymentService paymentService,
                               FileService fileService) {
        this.paymentService = paymentService;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        List<PaymentResponseDTO> latePayments = paymentService.getPendingPayments();

        fileService.writeLog(
            "Thread executed at " + LocalDateTime.now()
            + " | Late payments found: " + latePayments.size()
        );

        for (PaymentResponseDTO payment : latePayments) {
            fileService.writeLog(
                "Payment ID: " + payment.getId() +
                ", Amount: " + payment.getAmount() +
                ", Contract ID: " + payment.getContractId()
            );
        }
    }
}

