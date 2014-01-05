package reservation.databaseServices;

import reservation.reservationComponent.Reservation;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Florian Bauer on 05.01.14.
 * flbaue@posteo.de
 */
public class ReservationsDB implements IReservationsDB {

    private static final String RESERVATIONS_TABLE_NAME = "Reservations";
    private DataBaseUtil dataBaseUtil;

    public ReservationsDB(DataBaseUtil dataBaseUtil) {
        this.dataBaseUtil = dataBaseUtil;

        try {
            if (!this.dataBaseUtil.tableExists(RESERVATIONS_TABLE_NAME)) {

                String sql = "CREATE TABLE #TABLE# (Id INT PRIMARY KEY, Guest INT, Room INT)";
                sql = sql.replace("#TABLE#", RESERVATIONS_TABLE_NAME);

                this.dataBaseUtil.execute(sql);
            }
        } finally {
            this.dataBaseUtil.close();
        }
    }

    @Override
    public synchronized int getUniqueNumber() {
        return 0;
    }

    @Override
    public synchronized void saveReservation(Reservation reservation) {

    }

    @Override
    public synchronized Reservation getReservationByNumber(int number) {
        return null;
    }

    @Override
    public synchronized List<Reservation> getReservationsByRoomNumber(int number) {
        return null;
    }

    @Override
    public synchronized List<Reservation> getReservationsByGuestNumber(int number) {
        return null;
    }
}
