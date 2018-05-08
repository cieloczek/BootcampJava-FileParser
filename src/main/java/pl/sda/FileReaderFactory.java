package pl.sda;

import pl.sda.CSV.CSVFileReader;
import pl.sda.Excel.ExcelFileReader;
import pl.sda.JSON.JSONFileReader;

import java.io.FileReader;

public class FileReaderFactory {
    public static MyFileReader produce(String filepath){
        MyFileReader result = null;

        if(filepath.toLowerCase().endsWith(".csv")){
            return new CSVFileReader();
        }else if(filepath.toLowerCase().endsWith(".json")) {
            return new JSONFileReader();
        }else if(filepath.toLowerCase().endsWith(".xlsx")){
            return new ExcelFileReader();
        }return null;
    }
}
