package exceptions;

public class FileNotFoundCustomException extends RuntimeException{

 public FileNotFoundCustomException(String message){
        super(message);
 }
}
