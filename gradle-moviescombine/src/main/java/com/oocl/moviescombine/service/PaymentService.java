package com.oocl.moviescombine.service;

import com.oocl.moviescombine.dto.PaymentRequest;
import com.oocl.moviescombine.dto.ReserveSeatRequest;
import com.oocl.moviescombine.entity.Payment;
import com.oocl.moviescombine.exception.NoPaymentFoundException;
import com.oocl.moviescombine.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private SessionService sessionService;

    public PaymentService(PaymentRepository paymentRepository, SessionService sessionService) {
        this.paymentRepository = paymentRepository;
        this.sessionService = sessionService;
    }

    public Payment addPayment(PaymentRequest paymentRequest) {
        paymentRequest.getPayment().setPhoneNumber(paymentRequest.getPhoneNumber());
        paymentRequest.getPayment().setCardHolderName(paymentRequest.getCardHolderName());
        paymentRequest.getPayment().setCreditCardNumber(paymentRequest.getCreditCardNumber());
        ReserveSeatRequest reserveSeatRequest = new ReserveSeatRequest(paymentRequest.getPayment().getSelectedSeats(), "r");
        if (!sessionService.checkSeats(paymentRequest.getPayment().getSessionId(), reserveSeatRequest)){
            throw new NoPaymentFoundException();
        }
        sessionService.reserveSeat(paymentRequest.getPayment().getSessionId(), reserveSeatRequest);
        System.out.println(paymentRequest.getPayment().toString());
        return paymentRepository.insert(paymentRequest.getPayment());
    }

    public Payment findById(String id) {
        return paymentRepository.findById(id).orElseThrow(NoPaymentFoundException::new);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment save(Payment payment) {
        paymentRepository.save(payment);
        return payment;
    }
}
