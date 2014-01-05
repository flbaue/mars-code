package reservation.databaseServices;

import reservation.reservationComponent.AdditionalService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian Bauer on 05.01.14.
 * flbaue@posteo.de
 */
public class AdditionalServicesDB implements IAdditionalServicesDB {

    private static final String ADDITIONAL_SERVICES_TABLE_NAME = "AdditionalServices";
    private DataBaseUtil dataBaseUtil;

    public AdditionalServicesDB(DataBaseUtil dataBaseUtil) {
        this.dataBaseUtil = dataBaseUtil;

        try {
            if (!this.dataBaseUtil.tableExists(ADDITIONAL_SERVICES_TABLE_NAME)) {

                String sql = "CREATE TABLE #TABLE# (Id INT PRIMARY KEY, Service TEXT)";
                sql = sql.replace("#TABLE#", ADDITIONAL_SERVICES_TABLE_NAME);

                this.dataBaseUtil.execute(sql);
            }
        } finally {
            this.dataBaseUtil.close();
        }
    }

    @Override
    public synchronized int getUniqueNumber() {
        String sql = "SELECT Id FROM #TABLE# ORDER BY Id desc";
        sql = sql.replace("#TABLE#", ADDITIONAL_SERVICES_TABLE_NAME);

        ResultSet rs = dataBaseUtil.executeQuery(sql);
        int lastId = 0;

        try {
            if (rs.next()) {
                lastId = rs.getInt("Id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataBaseUtil.close();
        }

        lastId += 1;
        return lastId;
    }

    @Override
    public synchronized void saveAdditionalService(AdditionalService additionalService) {
        String sql = "SELECT * FROM #TABLE# WHERE Id = #V1#;";
        sql = sql.replace("#TABLE#", ADDITIONAL_SERVICES_TABLE_NAME);
        sql = sql.replace("#V1#", String.valueOf(additionalService.getNumber()));

        ResultSet rs = dataBaseUtil.executeQuery(sql);

        try {
            if (rs.next()) {
                // Update
                sql = "UPDATE #TABLE# SET Service = '#V1#' WHERE Id = #V2#";
                sql = sql.replace("#TABLE#", ADDITIONAL_SERVICES_TABLE_NAME);
                sql = sql.replace("#V1#", additionalService.getService());
                sql = sql.replace("#V2#", String.valueOf(additionalService.getNumber()));

                dataBaseUtil.execute(sql);

            } else {
                // Insert
                sql = "INSERT INTO #TABLE# (Id, Service) VALUES (#V1#, '#V2#')";
                sql = sql.replace("#TABLE#", ADDITIONAL_SERVICES_TABLE_NAME);
                sql = sql.replace("#V1#", String.valueOf(additionalService.getNumber()));
                sql = sql.replace("#V2#", additionalService.getService());

                dataBaseUtil.execute(sql);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataBaseUtil.close();
        }
    }

    @Override
    public synchronized AdditionalService getAdditionalServiceByNumber(int number) {
        String sql = "SELECT * FROM #TABLE# WHERE Id = #V1#;";
        sql = sql.replace("#TABLE#", ADDITIONAL_SERVICES_TABLE_NAME);
        sql = sql.replace("#V1#", String.valueOf(number));

        ResultSet rs = dataBaseUtil.executeQuery(sql);
        AdditionalService additionalService = null;

        try {
            if (rs.next()) {
                int id = rs.getInt("Id");
                String service = rs.getString("Service");

                additionalService = new AdditionalService(id, service);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataBaseUtil.close();
        }

        return additionalService;
    }

    @Override
    public synchronized List<AdditionalService> getAdditionalServicesByText(String service) {
        String sql = "SELECT * FROM #TABLE# WHERE Service like '%#V1#%'";
        sql = sql.replace("#TABLE#", ADDITIONAL_SERVICES_TABLE_NAME);
        sql = sql.replace("#V1#", service);

        ResultSet rs = dataBaseUtil.executeQuery(sql);
        List<AdditionalService> additionalServices = new ArrayList<>();

        try {
            while (rs.next()) {
                int idDB = rs.getInt("Id");
                String serviceDB = rs.getString("Name");
                AdditionalService additionalService = new AdditionalService(idDB, serviceDB);
                additionalServices.add(additionalService);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            dataBaseUtil.close();
        }

        return additionalServices;
    }
}
