package b15_exceptionAndDebug.bai_tap;

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(double side){
        super(side+" Nhập lại cạnh tam giác");
    }
}
