package FuramaResort.Exception;

public class IllegalChoiceException extends Exception {
    public IllegalChoiceException(int choice) {
        super("Nhập không đúng");
    }
}
