package pl.sda;

import java.io.IOException;
import java.util.List;

public interface MyFileWriter {
    void write(List<MyGenObj> inputList, String path) throws IOException;
}
