package utilities;
import exceptions.FileNotFoundCustomException;
import java.io.File;
import java.util.Arrays;

import static constants.Constants.DIRECTORY_PATH;
import static constants.Constants.validExtension;

public class Validations {

    public Boolean checkForValidExtension(String fileName)  {

        for(int i=0;i<validExtension.size();i++){
            if(fileName.endsWith(validExtension.get(i))){
                return true;
            }
        }
        return false;
    }

    public void isFileExist(File fileName) throws FileNotFoundCustomException {
        File listOfFiles = new File(DIRECTORY_PATH);

        if (fileName.exists()) {
            System.out.println("This file is present in given directory...");
        }
        else {
            System.out.println("Total files are: " + Arrays.toString(listOfFiles.list()));
            throw new FileNotFoundCustomException(fileName+" Not Found...");
        }
    }
}

