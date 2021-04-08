package b7_abstractClass_interface.bai_tap.Resizable;

public class Circle extends Shape {
    private double radius = 1.0;
    private String color = "blue";

    public Circle() {

    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", Area= " + getArea() +
                '}';
    }


    @Override
    public void resize(double percent) {
        radius = radius * percent / 100;
    }
}

