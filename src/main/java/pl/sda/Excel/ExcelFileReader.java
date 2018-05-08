package pl.sda.Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.sda.MyFileReader;
import pl.sda.MyGenObj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileReader implements MyFileReader{
    @Override
    public List<MyGenObj> read(String filePath) throws IOException {
        List<MyGenObj> result = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        List<String> headers = new ArrayList<>();
        if(rowIterator.hasNext()) {
           Row headerRow = rowIterator.next();
           Iterator<Cell> headerRowIterator = headerRow.iterator();
           while(headerRowIterator.hasNext()){
               Cell cell = headerRowIterator.next();
               headers.add(cell.getStringCellValue());
           }
           while(rowIterator.hasNext()){
               Row row = rowIterator.next();
               MyGenObj myGenObj = new MyGenObj();

               for(int i =0;i<headers.size();i++){
                   Cell cell = row.getCell(i);
                   CellType cellType;
                   String value="";
                   if(cell!=null) {
                       cellType = cell.getCellTypeEnum();
                       value = setCellValue(cell, cellType);


                   }
                   myGenObj.addValue(headers.get(i),value);
               }
               result.add(myGenObj);
           }

        }
        return result;
    }
    private String setCellValue(Cell cell,CellType cellType){
        String value ="";
        if(cellType.equals(CellType.NUMERIC)){
            value = String.valueOf(cell.getNumericCellValue());
        }else if(cellType.equals(CellType.STRING)){
            if(cell.getStringCellValue()!=null){
                value = cell.getStringCellValue();
            }else {
                value = "";
            }
        }else if(cellType.equals(CellType.BLANK)) {
            value = "";
        }else if(cellType.equals(CellType._NONE)){
            value= "";

        }else if(cellType.equals(CellType.FORMULA)){
            if((value=cell.getCellFormula().trim())!=null){
                return value;
            }else {
                value="";
            }
        }
        if(cell==null) {
            value= " a";
        }
        return value;
    }
}
