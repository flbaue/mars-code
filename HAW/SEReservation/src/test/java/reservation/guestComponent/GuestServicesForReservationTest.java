package reservation.guestComponent;

import org.junit.Test;
import reservation.databaseServices.IGuestsDB;
import reservation.databaseServices.TestGuestsDB;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Florian Bauer on 04.01.14.
 * flbaue@posteo.de
 */
public class GuestServicesForReservationTest {
    @Test
    public void testMarkGuestAsRegular() throws Exception {

        int customerNumber = 1;

        IGuestsDB guestsDB = new TestGuestsDB();
        IGuestServicesForReservation guestServicesForReservation = new GuestServicesForReservation(guestsDB);
        Guest guest = guestsDB.getGuestByNumber(customerNumber);

        assertFalse(guest.isRegularGuest());

        guestServicesForReservation.markGuestAsRegular(customerNumber);
        guest = guestsDB.getGuestByNumber(customerNumber);

        assertTrue(guest.isRegularGuest());
    }
}
