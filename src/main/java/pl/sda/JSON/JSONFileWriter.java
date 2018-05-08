package pl.sda.JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.MyFileWriter;
import pl.sda.MyGenObj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileWriter implements MyFileWriter {
    @Override
    public void write(List<MyGenObj> inputList, String path) throws IOException {

        FileWriter filewriter = new FileWriter("/Users/mateusz/JavaProjects/FileParser/src/main/resources/JSONtest.json");
        BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
        JSONArray jsonArray = new JSONArray();

        for (MyGenObj object : inputList) {
            JSONObject jsonObject = new JSONObject();
            object.getKey().forEach(e -> jsonObject.put(e, object.getValue(e)));
            jsonArray.put(jsonObject);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("JsonFile ->here should be the name of the table", jsonArray);

        bufferedWriter.write(jsonObject.toString());

//        for(MyGenObj object : inputList) {
//        bufferedWriter.write("{\n");
//            object.getKey().forEach(k->{
//                        try {
//                            bufferedWriter.write("\""+k+"\""+": "+"\""+object.getValue(k)+"\","+"\n");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//            });
//            bufferedWriter.write("},\n");
//    }

        bufferedWriter.close();
        filewriter.close();
    }

}
