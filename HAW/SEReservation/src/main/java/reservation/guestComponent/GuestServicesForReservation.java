package reservation.guestComponent;

import reservation.databaseServices.IGuestsDB;

/**
 * Created by Florian Bauer on 04.01.14.
 * flbaue@posteo.de
 */
public class GuestServicesForReservation implements IGuestServicesForReservation {

    IGuestsDB guestDB;

    public GuestServicesForReservation(IGuestsDB guestDB) {
        this.guestDB = guestDB;
    }

    public void markGuestAsRegular(int number) {

        Guest guest = guestDB.getGuestByNumber(number);
        guest.setRegularGuest(true);
    }
}
