package pl.sda;

import com.itextpdf.text.DocumentException;
import pl.sda.CSV.CSVFileReader;
import pl.sda.CSV.CSVFileWriter;
import pl.sda.Excel.ExcelFileWriter;
import pl.sda.JSON.JSONFileReader;
import pl.sda.JSON.JSONFileWriter;
import pl.sda.pl.sda.PDF.MyPdfWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<MyGenObj> obj = new ArrayList<>();
                FileReaderFactory readerFactory = new FileReaderFactory();
                CSVFileWriter writer = new CSVFileWriter();
        ExcelFileWriter excelFileWriter = new ExcelFileWriter();
        JSONFileWriter writer1 = new JSONFileWriter();
        try {
            obj = readerFactory.produce(".xlsx")
                    .read("/Users/mateusz/JavaProjects/FileParser/src/main/resources/excellTestData.xlsx");
            obj.forEach(System.out::println);
            String path = "/Users/mateusz/JavaProjects/FileParser/src/main/resources";
            writer1.write(obj, "a");
            //writer.write(obj,path);
//            obj.forEach(System.out::println);
            //  System.out.println(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("----------------------------");
//        FileType type;
//        CSVFileWriter writer = new CSVFileWriter();
//        String path = "/Users/mateusz/JavaProjects/FileParser/src/main/resources";
//        try {
//            writer.write(obj, path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        MyPdfWriter pdfWriter = new MyPdfWriter();
//        try {
//            pdfWriter.write();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
    }
}
