package com.gresidence.residence.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.gresidence.residence.Dto.PaymentRequestDTO;
import com.gresidence.residence.Dto.PaymentResponseDTO;
import com.gresidence.residence.Services.PaymentService;

@RestController
@RequestMapping("/gresidence/residence/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentResponseDTO addPayment(@RequestParam Long contractId,
                                         @RequestBody PaymentRequestDTO dto) {
        return paymentService.addPayment(contractId, dto);
    }

    @GetMapping
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentResponseDTO getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/contract/{contractId}")
    public List<PaymentResponseDTO> getPaymentsByContract(@PathVariable Long contractId) {
        return paymentService.getPaymentsByContract(contractId);
    }

    @PutMapping("/{id}/paid")
    public PaymentResponseDTO markAsPaid(@PathVariable Long id) {
        return paymentService.markAsPaid(id);
    }

    @GetMapping("/pending")
    public List<PaymentResponseDTO> getPendingPayments() {
        return paymentService.getPendingPayments();
    }
}
