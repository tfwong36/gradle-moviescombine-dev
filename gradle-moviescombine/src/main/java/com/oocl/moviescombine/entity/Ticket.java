package com.oocl.moviescombine.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document
public class Ticket {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String sessionId;
    private String reservedSeatNumber;

    public Ticket(String sessionId, String reservedSeatNumber) {
        this.sessionId = sessionId;
        this.reservedSeatNumber = reservedSeatNumber;
    }

    public Ticket() {
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

    public String getReservedSeatNumber() {
        return reservedSeatNumber;
    }

    public void setReservedSeatNumber(String reservedSeatNumber) {
        this.reservedSeatNumber = reservedSeatNumber;
    }

}
