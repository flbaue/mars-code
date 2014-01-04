package reservation.guestComponent;

import org.junit.Test;
import reservation.databaseServices.IGuestsDB;
import reservation.databaseServices.TestGuestsDB;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Florian Bauer on 04.01.14.
 * flbaue@posteo.de
 */
public class GuestServicesTest {
    @Test
    public void testCreateGuest() throws Exception {
        IGuestsDB guestsDB = new TestGuestsDB();
        IGuestServices guestServices = new GuestServices(guestsDB);

        Guest guest = guestServices.createGuest("Bob Bobby", "bobby@provider.de");

        assertEquals("Bob Bobby", guest.getName());
        assertEquals("bobby@provider.de", guest.getEmail().toString());
    }

    @Test
    public void testSearchForGuest() throws Exception {
        IGuestsDB guestsDB = new TestGuestsDB();
        IGuestServices guestServices = new GuestServices(guestsDB);

        List<Guest> guests = guestServices.searchForGuest("Kyle Broflovski");

        assertEquals("Kyle Broflovski", guests.get(0).getName());
    }
}
