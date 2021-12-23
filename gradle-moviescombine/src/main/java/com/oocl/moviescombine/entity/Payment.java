package com.oocl.moviescombine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class Payment {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String sessionId;
    private List<String> selectedSeats;
    private Integer unitPrice;
    private String phoneNumber;
    private String cardHolderName;
    private String creditCardNumber;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String qrKey;

    public Payment() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        this.qrKey = RandomStringUtils.random( 15, characters );
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", selectedSeats=" + selectedSeats +
                ", unitPrice=" + unitPrice +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", password='" + password + '\'' +
                ", qrKey='" + qrKey + '\'' +
                '}';
    }

    public String getQrKey() {
        return qrKey;
    }

    public void setQrKey(String qrKey) {
        this.qrKey = qrKey;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<String> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<String> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

