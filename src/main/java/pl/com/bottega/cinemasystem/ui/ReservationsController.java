package pl.com.bottega.cinemasystem.ui;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cinemasystem.api.CreateReservationRequest;
import pl.com.bottega.cinemasystem.api.CreateReservationResponse;
import pl.com.bottega.cinemasystem.api.ReservationManager;
import org.springframework.web.bind.annotation.*;
import pl.com.bottega.cinemasystem.api.*;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    private ReservationManager reservationManager;
    private ReservationCatalog reservationCatalog;

    public ReservationsController(ReservationManager reservationManager, ReservationCatalog reservationCatalog) {
        this.reservationManager = reservationManager;
        this.reservationCatalog = reservationCatalog;
    }

    public CreateReservationResponse create(CreateReservationRequest reservationRequest){
        return reservationManager.createReservation(reservationRequest);
    }

    public BrowseReservationResponse browseReservations(@ModelAttribute BrowseReservationRequest request) {
        return reservationCatalog.browseReservation(request);
    }
}
