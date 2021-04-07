package b5_AccessModifier_staticMethod_staticProperty.bai_tap.Cricle;
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cricle c1=new Cricle();
        System.out.println(c1);
        Cricle c2=new Cricle(5.0,"blue");
        System.out.println(c2);
        System.out.println("Please input the radius of the circle:");
        double radius = input.nextInt();
        c2.setRadius(radius);
        System.out.println(c2);
    }
}
