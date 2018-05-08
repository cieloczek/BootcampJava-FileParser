package pl.sda.CSV;


import pl.sda.MyFileReader;
import pl.sda.MyGenObj;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  CSVFileReader implements MyFileReader {
    private static final String CSV_FILE_NAME ="data.csv";

        public List<MyGenObj> read (String filePath) throws IOException {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] headers = null;
            String line;
            List<MyGenObj> objectList = new ArrayList<>();
            int i = 0;

            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                if (i == 0) {
                    headers = line.split(";");
                    i++;
                } else {
                    MyGenObj parsedObject = parseCSRow(headers, line);
                    objectList.add(parsedObject);
                }
            }

            return objectList;
        }

        private MyGenObj parseCSRow(String[] headers, String line) {

            MyGenObj something = new MyGenObj();
            String[] values = line.split(";");
            for (int i = 0; i < headers.length; i++) {
                setPersonalFieldFromCSV(something, headers[i], values[i]);
            }
            return something;
        }

        private void setPersonalFieldFromCSV(MyGenObj genObj, String header, String value) {
            genObj.addValue(header,value);
        }




    }
