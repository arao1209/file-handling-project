import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import constants.Constants;
import exceptions.FileExtensionNotValid;
import exceptions.FileNotFoundCustomException;
import service.FileServiceImpl;
import utilities.Validations;

public class FileExample {

    private File getValidFileNameFromUser(Scanner scanner) throws FileExtensionNotValid {

        System.out.println("Enter File Name: ");
        String userFileName = scanner.next();

        File fileName = new File(Constants.DIRECTORY_PATH.concat("\\").concat(userFileName));

        Validations validations = new Validations();
        Boolean flag = validations.checkForValidExtension(userFileName);

        if(Boolean.TRUE.equals(flag)){
            validations.isFileExist(fileName);
            return fileName;
        }
        else{
            throw new FileExtensionNotValid("Not a valid extension...");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FileExample fileExample = new FileExample();
        try{

            File fileName = fileExample.getValidFileNameFromUser(scanner);

            FileServiceImpl fileService = new FileServiceImpl();

            System.out.println("Do you want to read or write file? For Read press 1 and For Write press 2: ");
            int option = scanner.nextInt();

            if(option == 1){
                fileService.fileRead(fileName);
            }
            else if(option == 2){
                System.out.println("Type Text which you want to write in original file: ");
                Scanner scanner1 = new Scanner(System.in);

                String textNeedsToWrite = scanner1.nextLine();

                fileService.fileWrite(fileName, textNeedsToWrite);
            }
            else{
                System.out.println("Enter 1 or 2 only!!!!");
            }

        }
        catch (FileExtensionNotValid | FileNotFoundCustomException | IOException e){
            System.out.println(e.getMessage());
        }


    }

}
