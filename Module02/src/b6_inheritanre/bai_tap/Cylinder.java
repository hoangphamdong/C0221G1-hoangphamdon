package b6_inheritanre.bai_tap;

public class Cylinder extends Circle {
    private double height=1.0;
    public Cylinder(){}
    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    public double getVolume(){
        return getArea()*height;
    }

    @Override
    public String toString() {
        return " Cylinder{" +
                " height=" + height +
                " Volume "+getArea()
                +" "+ super.toString()+
                '}';
    }

    public static void main(String[] args) {
        Cylinder cylinder=new Cylinder(5);
        System.out.println(cylinder);
    }
}
