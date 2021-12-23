package com.oocl.moviescombine.mapper;

import com.oocl.moviescombine.dto.PaymentRequest;
import com.oocl.moviescombine.dto.PaymentResponse;
import com.oocl.moviescombine.entity.Payment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class PaymentMapper {

    public PaymentResponse toResponse(PaymentRequest paymentRequest, Payment payment, String paymentStatus){
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPayment(paymentRequest.getPayment());
        paymentResponse.setSeatQuantity(payment.getSelectedSeats().size());
        paymentResponse.setTotalPrice(payment.getUnitPrice() * payment.getSelectedSeats().size());
        paymentResponse.setCardHolderName(paymentRequest.getCardHolderName());
        paymentResponse.setCreditCardNumber(paymentRequest.getCreditCardNumber());
        paymentResponse.setPaymentStatus(paymentStatus);
        return paymentResponse;
    }

}
