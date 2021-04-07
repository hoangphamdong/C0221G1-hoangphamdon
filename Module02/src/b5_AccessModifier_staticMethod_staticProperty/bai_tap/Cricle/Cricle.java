package b5_AccessModifier_staticMethod_staticProperty.bai_tap.Cricle;

public class Cricle {
    private double radius=1;
    private String color="red";
     public  Cricle(){
    }
    public Cricle(double radius,String color){
         this.radius=radius;
         this.color=color;

    }
    public Cricle(double radius){
         this.radius=radius;
    }
    void setRadius(double radius){
        this.radius=radius;
    }
    double getRadius(){
         return this.radius;
    }
    double getArea(){
        return radius*radius*3.14;
    }
    public String toString(){
         return "radius"+getRadius()+"Area:"+getArea();
    }
}
