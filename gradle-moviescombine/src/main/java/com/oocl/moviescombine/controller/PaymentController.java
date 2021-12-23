package com.oocl.moviescombine.controller;

import com.oocl.moviescombine.dto.*;
import com.oocl.moviescombine.entity.Payment;
import com.oocl.moviescombine.exception.PasswordCreateException;
import com.oocl.moviescombine.exception.WrongPasswordException;
import com.oocl.moviescombine.mapper.PaymentDetailsMapper;
import com.oocl.moviescombine.mapper.PaymentMapper;
import com.oocl.moviescombine.mapper.TicketDetailMapper;
import com.oocl.moviescombine.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    private PaymentMapper paymentMapper;
    private PaymentDetailsMapper paymentDetailsMapper;
    private TicketDetailMapper ticketDetailMapper;

    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper, PaymentDetailsMapper paymentDetailsMapper, TicketDetailMapper ticketDetailMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
        this.paymentDetailsMapper = paymentDetailsMapper;
        this.ticketDetailMapper = ticketDetailMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse addPayment(@RequestBody PaymentRequest paymentRequest){
        Payment payment = paymentService.addPayment(paymentRequest);
        if (payment == null){ //no seat
            String paymentStatus = "Fail";
            paymentRequest.setPayment(paymentRequest.getPayment());
            return paymentMapper.toResponse(paymentRequest, payment, paymentStatus);
        }
        paymentRequest.setPayment(payment);
        String paymentStatus = "Success";
        return paymentMapper.toResponse(paymentRequest, payment, paymentStatus);
    }

    @GetMapping
    public List<PaymentDetails> getPaymentByPhoneNumber(@RequestParam String phoneNumber){
        return paymentService.findAll().stream().filter(payment -> payment.getPhoneNumber()!=null && payment.getPhoneNumber().equals(phoneNumber))
                .map(movie -> paymentDetailsMapper.toResponse(movie)).collect(Collectors.toList());
    }

    @PostMapping("/password")
    public void setPassword(@RequestBody SetPasswordRequest setPasswordRequest){
        Payment payment = paymentService.findById(setPasswordRequest.getId());
        if (payment.getPassword() != null){
            throw new PasswordCreateException();
        }
        payment.setPassword(setPasswordRequest.getPassword());
        paymentService.save(payment);
    }

    @PostMapping("/{id}")
    public TicketDetailResponse getPaymentById(@PathVariable String id, @RequestBody GetPaymentByIdRequest getPaymentByIdRequest){
        Payment payment = paymentService.findById(id);
        String password = getPaymentByIdRequest.getPassword();
        if (payment.getPassword() == null || payment.getPassword().isEmpty() || !payment.getPassword().equals(password)){
            throw new WrongPasswordException();
        }
        return ticketDetailMapper.toResponse(paymentDetailsMapper.toResponse(payment), payment.getQrKey());
    }

}
