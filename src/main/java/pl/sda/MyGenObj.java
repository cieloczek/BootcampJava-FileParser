package pl.sda;

import java.util.*;
import java.util.stream.Collectors;

public class MyGenObj {

    Map<String, String> values = new HashMap<>();


    public MyGenObj() {
    }

    public void addValue(String name, String value){
        if(value==null){
            value="";
        }
        values.put(name, value);

    }
    public String getValue(String name){
        return values.get(name);
    }
    public List<String> getKey(){
        return new ArrayList<>(values.keySet());
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
