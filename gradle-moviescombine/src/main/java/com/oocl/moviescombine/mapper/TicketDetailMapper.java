package com.oocl.moviescombine.mapper;

import com.oocl.moviescombine.dto.PaymentDetails;
import com.oocl.moviescombine.dto.SessionResponse;
import com.oocl.moviescombine.dto.TicketDetailResponse;
import com.oocl.moviescombine.entity.Session;
import org.springframework.stereotype.Component;

@Component
public class TicketDetailMapper {

    public TicketDetailResponse toResponse(PaymentDetails paymentDetails, String qrKey) {
        TicketDetailResponse ticketDetailResponse = new TicketDetailResponse();
        ticketDetailResponse.setPaymentDetails(paymentDetails);
        ticketDetailResponse.setQrKey(qrKey);
        return ticketDetailResponse;
    }
}
