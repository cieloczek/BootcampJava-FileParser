package pl.sda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader<GenObj> implements pl.sda.FileReader{

    private static final String CSV_FILE_NAME =  "data.csv";

    public List read (String path) throws IOException {
        path = getClass().getClassLoader().getResource(CSV_FILE_NAME).getPath();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] headers = null;
        String line;
        List objectList = new ArrayList<>();
        int i = 0;

        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            if (i == 0) {
                headers = line.split(";");
                i++;
            } else {
                GenObj parsedObject = parseCSRow(headers, line);
                objectList.add(parsedObject);
            }
        }

        return objectList;
    }

    private GenObj parseCSRow(String[] headers, String line) {
         GenObj something = new GenObj();
        String[] values = line.split(";");
        for (int i = 0; i < headers.length; i++) {
            setPersonalFieldFromCSV(something, headers[i], values[i]);
        }
        return something;
    }

    private void setPersonalFieldFromCSV(GenObj genObj, String header, String value) {
        genObj.addValue(header,value);
    }


}
