package com.oocl.moviescombine.dto;

import com.oocl.moviescombine.entity.Payment;

public class PaymentRequest {
    private Integer expiryMonth;
    private Integer expiryYear;
    private Integer cardCVV;
    private Payment payment;
    private String cardHolderName;
    private String creditCardNumber;
    private String phoneNumber;

    public PaymentRequest() {
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "payment=" + payment +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", expiryMonth=" + expiryMonth +
                ", expiryYear=" + expiryYear +
                ", cardCVV=" + cardCVV +
                ", phoneNumber=" + phoneNumber +
                '}';
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

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    public Integer getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(Integer cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
