package furamaResort.Exception;

public class EmailException extends Exception {
    public EmailException(){
        super("Format email must be abc@gamil.com");
    }
}
