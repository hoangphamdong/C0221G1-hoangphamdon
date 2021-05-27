package b7_abstractClass_interface.bai_tap.Resizable;

import b7_abstractClass_interface.bai_tap.Resizable.Shape;

public class Square extends Shape {
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
    public double getArea() {
        return side*side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}'+",Area="+ getArea();
    }



    @Override
    public void resize(double percent) {
    side=side*percent/100;
    }



}
