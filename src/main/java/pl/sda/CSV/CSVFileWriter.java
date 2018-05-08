package pl.sda.CSV;

import pl.sda.MyFileWriter;
import pl.sda.MyGenObj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter implements MyFileWriter{

    public void write(List<MyGenObj> inputList, String path) throws IOException{

        FileWriter filewriter = new FileWriter("/Users/mateusz/JavaProjects/FileParser/src/main/resources/test.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(filewriter);

            List<String> keys = inputList.get(0).getKey();
            for(int i =0; i< keys.size()-1; i++){
                bufferedWriter.append(keys.get(i)).append(";");
            }
            bufferedWriter.append(keys.get(keys.size()-1)).append("\n");

            for(MyGenObj obj : inputList ){
               for(int i =0; i<keys.size()-1;i++){
                    bufferedWriter.append(obj.getValue(keys.get(i))).append(";");
                }bufferedWriter.append(obj.getValue(keys.get(keys.size()-1)));
                bufferedWriter.append("\n");
            }
            bufferedWriter.close();
            filewriter.close();


    }
}
