package pl.sda.Excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.sda.MyFileWriter;
import pl.sda.MyGenObj;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class ExcelFileWriter implements MyFileWriter {
    @Override
    public void write(List<MyGenObj> inputList, String path) throws IOException {
        FileOutputStream fostream = new FileOutputStream("/Users/mateusz/JavaProjects/FileParser/src/main/resources/File.xlsx");
     //   File file = new File("/Users/mateusz/JavaProjects/FileParser/src/main/resources/File.xlsx");
        List<String> headers = inputList.get(0).getKey();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
            int i = 0;
            Row headersRow = sheet.createRow(i);
            for(int x = 0; x<headers.size(); x++){
                Cell cell = headersRow.createCell(x);
                cell.setCellValue(headers.get(x));
            }
            i++;
            for(MyGenObj object : inputList ){
            Row row = sheet.createRow(i);
            int j =0;
            for(String header : headers){
                Cell cell = row.createCell(j);
                cell.setCellValue(object.getValue(header));
                j++;
            }
            i++;
            }
            workbook.write(fostream);
            workbook.close();
           fostream.close();
        }


    }
