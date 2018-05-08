import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import pl.sda.Excel.ExcelFileReader;
import pl.sda.MyFileReader;
import pl.sda.MyFileWriter;
import pl.sda.MyGenObj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReaderTest {
    List<MyGenObj>  objectList = new ArrayList<>();
    MyFileReader  reader = new ExcelFileReader();

    @Test
    void read(){
        //Given
        MyGenObj first = new MyGenObj();
        first.addValue("Imię","Mateusz");
        first.addValue("nazwisko","Ciesielski");
        first.addValue("płeć","");
        MyGenObj second = new MyGenObj();
        second.addValue("Imię","Michał");
        second.addValue("nazwisko", "Światowy");
        second.addValue("płeć","M");
        MyGenObj third = new MyGenObj();
        third.addValue("Imię","Michał");
        third.addValue("nazwisko","Polski");
        third.addValue("płeć","M");
        objectList.add(first);
        objectList.add(second);
        objectList.add(third);
        System.out.println(objectList.toString());
        //when
        List<MyGenObj> result = new ArrayList<>();
        try {
          result= reader.read("/Users/mateusz/JavaProjects/FileParser/src/main/resources/excellTestData.xlsx");
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
       //then
        Assertions.assertTrue(result.toString().equals(objectList.toString()));
    }
}
