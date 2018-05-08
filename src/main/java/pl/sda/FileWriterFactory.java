package pl.sda;

import pl.sda.CSV.CSVFileWriter;
import pl.sda.Excel.ExcelFileWriter;
import pl.sda.JSON.JSONFileWriter;

public class FileWriterFactory {
    public static MyFileWriter produce(String filepath){

        if(filepath.toLowerCase().endsWith(".csv")){
            return new CSVFileWriter();
        }else if(filepath.toLowerCase().endsWith(".json")) {
            return new JSONFileWriter();
        }else if(filepath.toLowerCase().equals(".xlsx")){
            return new ExcelFileWriter();
        }else if(filepath.toLowerCase().equals(".pdf")){
        //    return new PDFFileWriter();         //TODO PDF FILE WRITER NEEDS TO BE FINISHED
            return null;
        }return null;
    }




    /*
        FILE WRITERS SHOULD GET PATH OF INPUT AND OUTPUT SO IT CONVERTS FILE TO FILE

     */
}
