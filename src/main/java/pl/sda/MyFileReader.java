package pl.sda;

import java.io.IOException;
import java.util.List;

public interface MyFileReader {
     List<MyGenObj> read(String filePath) throws IOException;

}
