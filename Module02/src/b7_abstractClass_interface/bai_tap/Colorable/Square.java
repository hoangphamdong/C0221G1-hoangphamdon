package b7_abstractClass_interface.bai_tap.Colorable;

public class Square extends Shape implements Colorable{
    private double side=1.0;
    public Square(){}

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public String toString() {
        return "Area: "+getArea();

    }
}
