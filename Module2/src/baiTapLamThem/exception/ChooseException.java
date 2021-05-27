package baiTapLamThem.exception;

public class ChooseException extends Exception {
    public ChooseException(String message) {
        super("Vui lòng nhập từ 1--->4");
    }
}
