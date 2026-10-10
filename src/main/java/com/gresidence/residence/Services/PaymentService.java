package com.gresidence.residence.Services;

import java.util.List;

import com.gresidence.residence.Entities.Payment;
import com.gresidence.residence.Dto.PaymentRequestDTO;
import com.gresidence.residence.Dto.PaymentResponseDTO;

public interface PaymentService {
    PaymentResponseDTO addPayment(Long contractId, PaymentRequestDTO dto);
    PaymentResponseDTO getPaymentById(Long id);
    List<PaymentResponseDTO> getPaymentsByContract(Long contractId);
    List<PaymentResponseDTO> getAllPayments();
    PaymentResponseDTO markAsPaid(Long paymentId);
    List<PaymentResponseDTO> getPendingPayments();
    void deletePayment(Long id);
}
