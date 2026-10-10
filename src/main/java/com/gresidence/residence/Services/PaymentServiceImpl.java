package com.gresidence.residence.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gresidence.residence.Dal.ContractRepository;
import com.gresidence.residence.Dal.PaymentRepository;
import com.gresidence.residence.Dto.PaymentRequestDTO;
import com.gresidence.residence.Dto.PaymentResponseDTO;
import com.gresidence.residence.Entities.Contract;
import com.gresidence.residence.Entities.Payment;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ContractRepository contractRepository;

    private PaymentResponseDTO mapToDTO(Payment p) {
        return new PaymentResponseDTO(
            p.getId(),
            p.getAmount(),
            p.getDate(),
            p.getStatus(),
            p.getContract().getId()
        );
    }

    @Override
    public PaymentResponseDTO addPayment(Long contractId, PaymentRequestDTO dto) {
        Contract contract = contractRepository.findById(contractId)
            .orElseThrow(() -> new RuntimeException("Contract not found"));

        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setContract(contract);
        payment.setStatus("PENDING");
        payment.setDate(LocalDate.now());

        return mapToDTO(paymentRepository.save(payment));
    }

    @Override
    public PaymentResponseDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Payment not found"));
        return mapToDTO(payment);
    }

    @Override
    public List<PaymentResponseDTO> getPaymentsByContract(Long contractId) {
        if (!contractRepository.existsById(contractId)) {
            throw new RuntimeException("Contract not found");
        }
        return paymentRepository.findByContractId(contractId).stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
            .map(this::mapToDTO)
            .toList();
    }

    @Override
    public PaymentResponseDTO markAsPaid(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
            .orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setStatus("PAID");
        payment.setDate(LocalDate.now());
        return mapToDTO(paymentRepository.save(payment));
    }

    @Override
    public List<PaymentResponseDTO> getPendingPayments() {
        return paymentRepository.findByStatusAndDateBefore("PENDING", LocalDate.now())
            .stream()
            .map(this::mapToDTO)
            .toList();
    }

    
    

    @Override
    public void deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Payment not found");
        }
        paymentRepository.deleteById(id);
    }
}
