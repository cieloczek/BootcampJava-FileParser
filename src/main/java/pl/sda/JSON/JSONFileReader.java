package pl.sda.JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.MyFileReader;
import pl.sda.MyGenObj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JSONFileReader implements MyFileReader{
    public List<MyGenObj> read(String filePath) throws IOException {
        List<MyGenObj> results = new ArrayList<>();

        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String json = new String(bytes, "UTF-8");

        JSONObject jsonObject = new JSONObject(json);
        String rootKey = jsonObject.keySet().iterator().next();
        JSONArray rawValues = new JSONArray(jsonObject.get(rootKey).toString());

        for (Object rawValue : rawValues) {
            JSONObject val = new JSONObject(rawValue.toString());

            List<String> keys = new ArrayList<>(val.keySet());
            results.add(toObj(keys, val));
        }
        return results;
    }



    private MyGenObj toObj(List<String> keys, JSONObject values){
            MyGenObj tempObject = new MyGenObj();
            keys.forEach(e-> tempObject.addValue(e,values.get(e).toString()));
            return tempObject;
        }
}
