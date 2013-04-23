package net.tipp24.qs.tools.testconverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestConverter {

    public static final int LOTTONORMALSHEET = 0;
    public static final int LOTTOSYTEMSHEET = 1;
    public static final int LOTTOVEWSHEET = 2;
    // private static final int STARTROW = 2;
    private static final int ENDROW = 116;
    private static final int STARTCELL = 3;
    private static final int ENDCELL = 324;
    private static final int DATECELL = 2;
    // Rows
    private static final int TICKETNUMBER = 2;
    private static final int SUBSCRIPTION = 5;
    private static final int SUBSCRIPTION_RE = 6;
    private static final int DURATION = 7;
    private static final int DRAWDAY_SAT = 10;
    private static final int DRAWDAY_WED = 11;
    private static final int DRAWDAY_COM1 = 12;
    private static final int DRAWDAY_COM2 = 13;
    private static final int S77 = 14;
    private static final int S6 = 15;
    private static final int GLS = 16;
    private static final int SYSTEM = 17;
    private static final int BLOCKS = 19;
    private static final int PRICE = 21;
    private static final int DATESSTART = 23;
    private static final int DATESEND = ENDROW;
    private static final String[] SITES = new String[] {"COM", "DE", "LSU"};
    private static List<Ticket> tickets;
    private static DecimalFormat twoDForm = new DecimalFormat("#.##");

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

        for (String site : SITES) {
            tickets = new ArrayList<Ticket>();
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(".\\BroSis_Tickets_" + site + ".xlsx"));
            for (int sheetI = 0; sheetI < 3; sheetI++) {
                Sheet sheet = workbook.getSheetAt(sheetI);
                for (int iCell = STARTCELL; iCell <= ENDCELL; iCell++) {
                    Ticket ticket = new Ticket();
                    Cell cell = sheet.getRow(TICKETNUMBER).getCell(iCell);
                    if (cell != null && cell.getCellType() == 0) {
                        ticket.setTicketnumber((int) cell.getNumericCellValue());
                    } else {
                        continue;
                    }
                    cell = sheet.getRow(SUBSCRIPTION).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1) {
                        ticket.setSubscription(cell.getStringCellValue().equalsIgnoreCase("X"));
                    }
                    cell = sheet.getRow(SUBSCRIPTION_RE).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1) {
                        ticket.setSubscriptionRe(cell.getStringCellValue().equalsIgnoreCase("X"));
                    }
                    cell = sheet.getRow(DURATION).getCell(iCell);
                    if (cell != null && cell.getCellType() == 0) {
                        ticket.setDuration((int) cell.getNumericCellValue());
                    }
                    cell = sheet.getRow(DRAWDAY_SAT).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1 && cell.getStringCellValue().equalsIgnoreCase("X")) {
                        ticket.setDrawday("Samstag");
                    }
                    cell = sheet.getRow(DRAWDAY_WED).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1 && cell.getStringCellValue().equalsIgnoreCase("X")) {
                        ticket.setDrawday("Mittwoch");
                    }
                    cell = sheet.getRow(DRAWDAY_COM1).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1 && cell.getStringCellValue().equalsIgnoreCase("X")) {
                        ticket.setDrawday("Kombi");
                    }
                    cell = sheet.getRow(DRAWDAY_COM2).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1 && cell.getStringCellValue().equalsIgnoreCase("X")) {
                        ticket.setDrawday("Kombi");
                    }
                    cell = sheet.getRow(S77).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1) {
                        ticket.setS77(cell.getStringCellValue().equalsIgnoreCase("X"));
                    }
                    cell = sheet.getRow(S6).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1) {
                        ticket.setS6(cell.getStringCellValue().equalsIgnoreCase("X"));
                    }
                    cell = sheet.getRow(GLS).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1) {
                        ticket.setGls(cell.getStringCellValue().equalsIgnoreCase("X"));
                    }
                    cell = sheet.getRow(SYSTEM).getCell(iCell);
                    if (cell != null && cell.getCellType() == 1) {
                        ticket.setSystem(cell.getStringCellValue());
                    }
                    if (sheetI == LOTTONORMALSHEET) {
                        ticket.setType("normal");
                    } else if (sheetI == LOTTOSYTEMSHEET) {
                        ticket.setType("voll");
                    } else if (sheetI == LOTTOVEWSHEET) {
                        ticket.setType("vew");
                    }
                    cell = sheet.getRow(BLOCKS).getCell(iCell);
                    if (cell != null && cell.getCellType() == 0) {
                        ticket.setBlocks((int) cell.getNumericCellValue());
                    }
                    cell = sheet.getRow(PRICE).getCell(iCell);
                    if (cell != null) {
                        // double temp = cell.getNumericCellValue();
                        ticket.setPrice(twoDForm.format(cell.getNumericCellValue()));
                        // System.out.println("ticket: " + ticket.getTicketnumber() + ", found: " + temp + ", set to: " + ticket.getPrice());
                    }
                    // Erstes draw date
                    for (int iRow = DATESSTART; iRow <= DATESEND; iRow++) {
                        cell = sheet.getRow(iRow).getCell(iCell);
                        if (cell != null && cell.getCellType() == 1 && cell.getStringCellValue().equalsIgnoreCase("X")) {
                            Cell datecell = sheet.getRow(iRow).getCell(DATECELL);
                            ticket.setDrawdate(datecell.getDateCellValue());
                            break;
                        }
                    }
                    tickets.add(ticket);
                }
            }
            // System.out.println(tickets);
            WriteUtil.writeFile(tickets, site);
        }
    }
}
