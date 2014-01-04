package reservation.databaseServices;

import reservation.reservationComponent.Reservation;

import java.util.List;

/**
 * Created by Florian Bauer on 04.01.14.
 * flbaue@posteo.de
 */
public interface IReservationDB {

    int getUniqueNumber();

    void saveReservation(Reservation guest); //TODO throws exception!!

    Reservation getReservationByNumber(int number);

    List<Reservation> getReservationsByRoomNumber(int number);

    List<Reservation> getReservationsByGuestNumber(int number);
}
