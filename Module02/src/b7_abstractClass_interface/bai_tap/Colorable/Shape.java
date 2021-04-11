package b7_abstractClass_interface.bai_tap.Colorable;

public abstract class Shape {
    public abstract double getArea();
    public   String color="red";

    public Shape(){}

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String toString();
}
