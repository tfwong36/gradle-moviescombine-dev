package com.oocl.moviescombine.dto;

public class TicketDetailResponse {
    private PaymentDetails paymentDetails;
    private String qrKey;

    public TicketDetailResponse() {
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getQrKey() {
        return qrKey;
    }

    public void setQrKey(String qrKey) {
        this.qrKey = qrKey;
    }
}
