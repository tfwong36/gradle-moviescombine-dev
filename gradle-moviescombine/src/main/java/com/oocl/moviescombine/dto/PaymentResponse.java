package com.oocl.moviescombine.dto;

import com.oocl.moviescombine.entity.Payment;

public class PaymentResponse {
    private Payment payment;
    private Integer seatQuantity;
    private Integer totalPrice;
    private String cardHolderName;
    private String creditCardNumber;
    private String paymentStatus;

    public PaymentResponse() {
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "payment=" + payment +
                ", seatQuantity=" + seatQuantity +
                ", totalPrice=" + totalPrice +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }

    public Integer getSeatQuantity() {
        return seatQuantity;
    }

    public void setSeatQuantity(Integer seatQuantity) {
        this.seatQuantity = seatQuantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
