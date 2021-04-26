package bai_lam_them.display;

public class IllegalChoiceException extends Exception {
    public IllegalChoiceException(int Choice) {
        super("Nhập không đúng");
    }
}
