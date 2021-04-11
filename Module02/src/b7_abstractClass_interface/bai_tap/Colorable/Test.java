package b7_abstractClass_interface.bai_tap.Colorable;

public class Test {
    public static void main(String[] args) {
        Shape square =new Square();
        Shape circle =new Circle();
        Shape[] shapes={square,circle};
        for (Shape shape:shapes){
            System.out.println(shape);
            if (shape instanceof Square) {
                ((Square) shape).howToColor();
            }
        }




    }
}
