//import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.sda.JSON.JSONFileReader;


import java.util.Map;
import java.util.TreeMap;

public class JSONReaderTest {
    JSONFileReader reader=new JSONFileReader();
    @Test
    void testReader(){

        //given
        Map<String, String> vals = new TreeMap<>();
            vals.put("ID", "SGML");
            vals.put("SortAs", "SGML");
                 vals.put("GlossTerm", "Standard Generalized Markup Language");
                 vals.put("Acronym", "SGML");
                 vals.put("Abbrev", "ISO 8879:1986");
                //when
                 String result = "Abbrev=ISO 8879:1986, Acronym=SGML, GlossTerm=Standard Generalized Markup Language, ID=SGML, SortAs=SGML";
           //then



        System.out.println(vals.toString());


    }
}
