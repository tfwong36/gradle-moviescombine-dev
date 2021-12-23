package com.oocl.moviescombine.mapper;

import com.oocl.moviescombine.dto.PaymentDetails;
import com.oocl.moviescombine.entity.Payment;
import com.oocl.moviescombine.service.CinemaService;
import com.oocl.moviescombine.service.MovieService;
import com.oocl.moviescombine.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentDetailsMapper {
    @Autowired
    SessionService sessionService;
    @Autowired
    MovieService movieService;
    @Autowired
    CinemaService cinemaService;

    private SessionMapper sessionMapper;

    public PaymentDetailsMapper(SessionMapper sessionMapper) {
        this.sessionMapper = sessionMapper;
    }

    public PaymentDetails toResponse(Payment payment) {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setPhoneNumber(payment.getPhoneNumber());
        paymentDetails.setSelectedSeats(payment.getSelectedSeats());
        paymentDetails.setUnitPrice(payment.getUnitPrice());
        paymentDetails.setCreditCardNumber(payment.getCreditCardNumber());
        paymentDetails.setSessionResponse(sessionMapper.toSessionResponse(sessionService.findById(payment.getSessionId())));
        paymentDetails.setCinema(cinemaService.findById(paymentDetails.getSessionResponse().getCinemaId()));
        paymentDetails.setMovie(movieService.getById(paymentDetails.getSessionResponse().getMovieId()));
        paymentDetails.setPaymentId(payment.getId());
        paymentDetails.setCardHolderName(payment.getCardHolderName());
        return paymentDetails;
    }
}
