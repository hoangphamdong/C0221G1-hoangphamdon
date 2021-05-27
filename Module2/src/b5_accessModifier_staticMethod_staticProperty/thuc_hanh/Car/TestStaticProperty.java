package b5_accessModifier_staticMethod_staticProperty.thuc_hanh.Car;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 =new Car("Mazda3","Skyactiv3");
        System.out.println(Car.numberOfCars);
        Car car2 =new Car("Mazda6","Skyactiv6");
        System.out.println(Car.numberOfCars);
    }
}
