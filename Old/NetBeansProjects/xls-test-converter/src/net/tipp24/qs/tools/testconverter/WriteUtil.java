/*
 * $Id$
 * (c) Copyright eSailors IT Solutions GmbH, 2013
 *
 * Created on 18.02.2013 by fbaue
 *
 * This file contains unpublished, proprietary trade secret information of
 * eSailors IT Solutions GmbH. Use, transcription, duplication and
 * modification are strictly prohibited without prior written consent of
 * eSailors IT Solutions GmbH.
 *
 */
package net.tipp24.qs.tools.testconverter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class WriteUtil {

    private List<Ticket> tickets;
    private String user;
    private String site;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void writeFile(List<Ticket> tickets, String site) throws IOException {

        new WriteUtil(tickets, site);
    }

    private WriteUtil() {

        // Util
    }

    private WriteUtil(List<Ticket> t, String s) throws IOException {

        this.tickets = t;
        this.site = s;
        run();
    }

    private void run() throws IOException {

        String pathX = ".\\{date}";
        Map<String, List<Ticket>> typemap = splittTicketsByType(tickets);
        for (String type : typemap.keySet()) {
            String pathtype = pathX.replace("{type}", type);
            Map<Date, List<Ticket>> datemap = splittTicketsByDate(typemap.get(type));
            if (site.equals("COM") || site.equals("DE")) {
                if (type.equals("normal")) {
                    user = "test_normal";
                } else if (type.equals("voll")) {
                    user = "test_voll";
                } else if (type.equals("vew")) {
                    user = "test_vew";
                }
            } else {
                if (type.equals("normal")) {
                    user = "test_normal@web.de";
                } else if (type.equals("voll")) {
                    user = "test_voll@web.de";
                } else if (type.equals("vew")) {
                    user = "test_vew@web.de";
                }
            }
            for (Date date : datemap.keySet()) {
                // System.out.println(date);
                String path = pathtype.replace("{date}", dateFormat.format(date));
                File file = new File(path);
                if (file.exists())
                    file.delete();
                file.mkdirs();
                file.setWritable(true);
                file.setReadable(true);
                tickets = datemap.get(date);
                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet worksheet;
                if (type.equals("normal")) {
                    worksheet = workbook.createSheet("Lotto-Tickets");
                } else {
                    worksheet = workbook.createSheet("LottoSystem_Tickets");
                }
                createHeadlines(worksheet, type);
                writeValues(worksheet);
                if (worksheet.getPhysicalNumberOfRows() > 1) {
                    // System.out.println(dateFormat.format(date) + "_" + type);
                    FileOutputStream fileOut = new FileOutputStream(path + "\\Generator_" + type + "_" + site + "_"
                            + dateFormat.format(date) + ".xls");
                    workbook.write(fileOut);
                }
                createPriceList(path, type, date);
            }
        }
    }

    private void createPriceList(String path, String type, Date date) throws IOException {

        BufferedWriter out = new BufferedWriter(new FileWriter(path + "\\pricelist_" + type + "_" + site + "_" + dateFormat.format(date)
                + ".txt"));
        for (Ticket ticket : tickets) {
            out.append(ticket.getTicketnumber() + ":" + ticket.getPrice());
            out.newLine();
        }
        out.close();
    }

    private Map<String, List<Ticket>> splittTicketsByType(List<Ticket> tickets) {

        Map<String, List<Ticket>> typemap = new HashMap<String, List<Ticket>>();
        for (Ticket ticket : tickets) {
            String type = ticket.getType();
            // System.out.println(type);
            if (!typemap.containsKey(type)) {
                typemap.put(type, new ArrayList<Ticket>());
            }
            typemap.get(type).add(ticket);
        }
        return typemap;
    }

    private Map<Date, List<Ticket>> splittTicketsByDate(List<Ticket> tickets) {

        Map<Date, List<Ticket>> datemap = new HashMap<Date, List<Ticket>>();
        for (Ticket ticket : tickets) {
            Date date = ticket.getDrawdate();
            if (!datemap.containsKey(date)) {
                datemap.put(date, new ArrayList<Ticket>());
            }
            datemap.get(date).add(ticket);
        }
        return datemap;
    }

    private void writeValues(HSSFSheet worksheet) {

        // writevalues
        Row row = null;
        Cell cell = null;
        int iRow = 1;
        for (int ticketI = 0; ticketI < tickets.size(); ticketI++) {
            if (tickets.get(ticketI).isSubscriptionRe()) {
                continue;
            }
            row = worksheet.createRow(iRow);
            cell = row.createCell(0);
            cell.setCellType(1);
            cell.setCellValue(user); // TODO nach ticket typ und seite
            cell = row.createCell(1);
            cell.setCellType(1);
            cell.setCellValue("qmtest1");
            cell = row.createCell(3);
            cell.setCellType(1);
            cell.setCellValue("Kreditkarte");
            cell = row.createCell(6);
            cell.setCellType(1);
            cell.setCellValue(tickets.get(ticketI).getDrawday());
            cell = row.createCell(10);
            cell.setCellType(1);
            cell.setCellValue(tickets.get(ticketI).isS77());
            cell = row.createCell(11);
            cell.setCellType(1);
            cell.setCellValue(tickets.get(ticketI).isS6());
            cell = row.createCell(12);
            cell.setCellType(1);
            cell.setCellValue(tickets.get(ticketI).isGls());
            cell = row.createCell(13);
            cell.setCellType(1);
            cell.setCellValue(tickets.get(ticketI).isSubscription());
            cell = row.createCell(14);
            cell.setCellType(0);
            cell.setCellValue(tickets.get(ticketI).getDuartion());
            cell = row.createCell(15);
            cell.setCellType(0);
            cell.setCellValue(tickets.get(ticketI).getTicketnumber());
            if (tickets.get(ticketI).getType().equals("normal")) {
                for (int feld = 1 + 15; feld <= tickets.get(ticketI).getBlocks() + 15; feld++) {
                    // System.out.println(feld + 14);
                    cell = row.createCell(feld);
                    cell.setCellType(1);
                    cell.setCellValue("1;2;3;4;5;6");
                }
            }
            if (tickets.get(ticketI).getType().equals("voll") || tickets.get(ticketI).getType().equals("vew")) {
                int amountNumbers = Integer.valueOf(tickets.get(ticketI).getSystem()) % 100;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < amountNumbers; i++) {
                    sb.append(Integer.toString(i + 1) + ";");
                }
                sb.deleteCharAt(sb.lastIndexOf(";"));
                cell = row.createCell(16);
                cell.setCellType(1);
                cell.setCellValue(tickets.get(ticketI).getType());
                cell = row.createCell(17);
                cell.setCellType(1);
                cell.setCellValue(tickets.get(ticketI).getSystem());
                cell = row.createCell(18);
                cell.setCellType(1);
                cell.setCellValue(sb.toString());
            }
            iRow++;
        }
    }

    private void createHeadlines(HSSFSheet worksheet, String type) {

        // create headlines
        int systemoffset = 0;
        Row row = worksheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellType(1);
        cell.setCellValue("Benutzer");
        cell = row.createCell(1);
        cell.setCellType(1);
        cell.setCellValue("passwort");
        cell = row.createCell(2);
        cell.setCellType(1);
        cell.setCellValue("PartnerId");
        cell = row.createCell(3);
        cell.setCellType(1);
        cell.setCellValue("Zahlart");
        cell = row.createCell(4);
        cell.setCellType(1);
        cell.setCellValue("VoucherCode");
        cell = row.createCell(5);
        cell.setCellType(1);
        cell.setCellValue("WebAd-ID");
        cell = row.createCell(6);
        cell.setCellType(1);
        cell.setCellValue("Spieltag");
        cell = row.createCell(7);
        cell.setCellType(1);
        cell.setCellValue("GK Lotto");
        cell = row.createCell(8);
        cell.setCellType(1);
        cell.setCellValue("GK Super6");
        cell = row.createCell(9);
        cell.setCellType(1);
        cell.setCellValue("GK Spiel77");
        cell = row.createCell(10);
        cell.setCellType(1);
        cell.setCellValue("Spiel77");
        cell = row.createCell(11);
        cell.setCellType(1);
        cell.setCellValue("Super6");
        cell = row.createCell(12);
        cell.setCellType(1);
        cell.setCellValue("gls");
        cell = row.createCell(13);
        cell.setCellType(1);
        cell.setCellValue("Dauerschein");
        cell = row.createCell(14);
        cell.setCellType(1);
        cell.setCellValue("Laufzeit");
        cell = row.createCell(15);
        cell.setCellType(1);
        cell.setCellValue("Losnummer");
        if (type.equals("voll") || type.equals("vew")) {
            cell = row.createCell(16);
            cell.setCellType(1);
            cell.setCellValue("SystemTyp");
            cell = row.createCell(17);
            cell.setCellType(1);
            cell.setCellValue("SystemName1");
            systemoffset = 2;
        }
        cell = row.createCell(16 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld1");
        if (type.equals("voll") || type.equals("vew")) {
            return;
        }
        cell = row.createCell(17 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld2");
        cell = row.createCell(18 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld3");
        cell = row.createCell(19 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld4");
        cell = row.createCell(20 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld5");
        cell = row.createCell(21 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld6");
        cell = row.createCell(22 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld7");
        cell = row.createCell(23 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld8");
        cell = row.createCell(24 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld9");
        cell = row.createCell(25 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld10");
        cell = row.createCell(26 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld11");
        cell = row.createCell(27 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld12");
        cell = row.createCell(28 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld13");
        cell = row.createCell(29 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("Feld14");
        cell = row.createCell(30 + systemoffset);
        cell.setCellType(1);
        cell.setCellValue("vorausdatierung");
    }
}
