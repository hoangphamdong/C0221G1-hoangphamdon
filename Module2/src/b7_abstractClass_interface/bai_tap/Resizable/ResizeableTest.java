package b7_abstractClass_interface.bai_tap.Resizable;

public class  ResizeableTest {
    public static void main(String[] args) {
        Shape circle=new Circle();
        Shape rectangle = new Rectangle();
        Shape square =new Square();
        Shape[] shapeArray={circle,rectangle,square};
        for (Shape shape:shapeArray){
            System.out.println(shape);
        }
        int i = (int) (Math.random()*100);
        System.out.println("Resize by "+i+"%");
        for (Shape shape:shapeArray){
            shape.resize(i);
        }
        for (Shape shape:shapeArray){
            System.out.println(shape);
        }


    }

}
