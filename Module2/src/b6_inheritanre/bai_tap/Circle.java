package b6_inheritanre.bai_tap;


public class Circle {
    private double radius=1.0;
    private String color="blue";
    public Circle(){

    }
    public Circle(double radius,String color){
        this.radius=radius;
        this.color=color;
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
    public double getArea(){
        return radius*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", Area= "+getArea()+
                '}';
    }

    public static void main(String[] args) {
        Circle circle=new Circle();
        System.out.println(circle);
    }
}
