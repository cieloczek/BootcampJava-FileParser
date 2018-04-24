package pl.sda;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CSVFileReader reader = new CSVFileReader();
        try {
            List<GenObj> obj = reader.readPerson("/Users/mateusz/JavaProjects/FileParser/data.csv");
            obj.forEach(System.out::println);
          //  System.out.println(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
