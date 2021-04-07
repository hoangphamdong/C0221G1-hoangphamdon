package b5_AccessModifier_staticMethod_staticProperty.thuc_hanh.Car;

public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;
    public Car(String name,String engine){
        this.name=name;
        this.engine=engine;
        numberOfCars++;
    }
}
