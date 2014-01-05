package reservation.databaseServices;

/**
 * Created by Florian Bauer on 05.01.14.
 * flbaue@posteo.de
 */
public class DBServicesFactory implements IDBServicesFactory {

    public static final int TEST_ENVIRONMENT = 0;
    public static final int PRODUCTION_ENVIRONMENT = 1;
    private final int environment;
    private IGuestsDB guestsDB;
    private IReservationsDB reservationsDB;
    private IAdditionalServicesDB additionalServicesDB;
    private DataBaseUtil dataBaseUtil;

    public DBServicesFactory(int environment, String dbDriver, String dbURL) {
        this.environment = environment;
        if (this.environment == PRODUCTION_ENVIRONMENT) {
            dataBaseUtil = new DataBaseUtil(dbURL, dbDriver);
        }
    }

    @Override
    public IGuestsDB getGuestsDB() {
        switch (environment) {
            case TEST_ENVIRONMENT:
                if (guestsDB == null) {
                    guestsDB = new TestGuestsDB();
                }
                return guestsDB;
            case PRODUCTION_ENVIRONMENT:
                if (guestsDB == null) {
                    guestsDB = new GuestsDB(dataBaseUtil);
                }
                return guestsDB;
            default:
                throw new UnsupportedOperationException();
        }

        // TODO support production environment
    }

    @Override
    public IReservationsDB getReservationsDB() {
        switch (environment) {
            case TEST_ENVIRONMENT:
                if (reservationsDB == null) {
                    reservationsDB = new TestReservationsDB();
                }
                return reservationsDB;
            default:
                throw new UnsupportedOperationException();
        }

        // TODO support production environment
    }

    @Override
    public IAdditionalServicesDB getAdditionalServicesDB() {
        switch (environment) {
            case TEST_ENVIRONMENT:
                if (additionalServicesDB == null) {
                    additionalServicesDB = new TestAdditionalServicesDB();
                }
                return additionalServicesDB;
            default:
                throw new UnsupportedOperationException();
        }

        // TODO support production environment
    }
}
