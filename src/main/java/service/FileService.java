package service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface FileService {

    void fileRead(File fileName) throws IOException;

    void fileWrite(File fileName, String textNeedsToWrite) throws IOException;

}
