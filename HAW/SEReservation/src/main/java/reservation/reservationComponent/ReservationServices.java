package reservation.reservationComponent;

import reservation.databaseServices.IAdditionalServicesDB;
import reservation.databaseServices.IReservationDB;

/**
 * Created by Florian Bauer on 04.01.14.
 * flbaue@posteo.de
 */
public class ReservationServices implements IReservationServices {

    IReservationDB reservationDB;
    IAdditionalServicesDB additionalServicesDB;

    public ReservationServices(IReservationDB reservationDB, IAdditionalServicesDB additionalServicesDB) {
        this.reservationDB = reservationDB;
        this.additionalServicesDB = additionalServicesDB;
    }

    @Override
    public AdditionalService createAdditionalService(String service) {
        AdditionalService additionalService = new AdditionalService(additionalServicesDB.getUniqueNumber(), service);
        additionalServicesDB.saveAdditionalService(additionalService);
        return additionalService;
    }

    @Override
    public Reservation createReservation(int guestNumber, int roomNumber) {
        Reservation reservation = new Reservation(reservationDB.getUniqueNumber(), guestNumber, roomNumber);
        reservationDB.saveReservation(reservation);
        return reservation;
    }

    @Override
    public void bookAdditionalService(int reservationNumber, int additionalServiceNumber) {
        Reservation reservation = reservationDB.getReservationByNumber(reservationNumber);
        reservation.addAdditionalService(additionalServiceNumber);
        reservationDB.saveReservation(reservation);
    }
}
