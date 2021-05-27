package b7_abstractClass_interface.bai_tap.Resizable;

public class Rectangle extends Shape {
    private double width=1.0;
    private double length=1.0;
    public Rectangle() {
    }
    public Rectangle(double width,double length){
        this.width=width;
        this.length=length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return getWidth()*getLength();
    }

    @Override
    public void resize(double percent) {
        width=width*percent/100;
        length=length*percent/100;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}'
                + ", area = " + getArea();
    }
}
