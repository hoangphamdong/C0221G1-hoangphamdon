package b7_abstractClass_interface.bai_tap.Colorable;

public class Circle extends Shape {
    private double radius=1.0;
    public Circle(){}
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Area: "+getArea();
    }
}
