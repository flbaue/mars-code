/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flbaue.xlsTestConverter;

import flbaue.xlsTestConverter.fileProcessors.FileProcessor;
import flbaue.xlsTestConverter.fileProcessors.FileProcessorFactory;
import flbaue.xlsTestConverter.products.ProductFactory;
import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author florianbauer
 */
public class XlsTestConverter {

    public static final String FILE_IDENTIFIER = "_tickets_";
    private final String appPath;
    /**
     *
     */
    public static final String[] PRODUCTS = new String[]{"lotto"};

    public static void main(String[] args) {

        XlsTestConverter app = new XlsTestConverter();
        app.run();

    }

    public XlsTestConverter() {
        appPath = "./";
    }

    public void run() {
        // 1. get files
        File[] files = getFiles();

        // 2. process each file into tickets and write output
        for (File file : files) {
            Ticket[] tickets = getTicketsFromFile(file);
            
            // 2.1 write output
            //ToDo
        }
    }

    private File[] getFiles() {

        File folder = new File(appPath);

        return folder.listFiles(new FilenameFilter() {
            public boolean accept(File file, String name) {
                return (name.contains(FILE_IDENTIFIER)) ? true : false;
            }
        });
    }

    private Ticket[] getTicketsFromFile(File file) {

        FileProcessor fileprocessor = FileProcessorFactory.getProcessor(ProductFactory.getProduct(file.getName()));
        return fileprocessor.getTicketsFromFile(file);
    }
}
