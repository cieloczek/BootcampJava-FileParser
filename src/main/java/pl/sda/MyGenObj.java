package pl.sda;

import java.util.HashMap;
import java.util.stream.Collectors;

public class MyGenObj {

    HashMap<String, String> values = new HashMap<>();


    public MyGenObj() {
    }

    public void addValue(String name, String value){
        values.put(name, value);

    }
    public String getValue(String name){
        return values.get(name);
    }

    @Override
    public  String toString() {
        return values.entrySet()
                .stream()
                .map(entry ->
                        (entry.getKey()+ " :  " + entry.getValue())+", ")
                .collect(Collectors.joining()).trim();
    }
}
