package Views.addNewService;

import Commons.impl.IOTextFileOfVillaImpl;
import Models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNewVilla {
    static Scanner input=new Scanner(System.in);
    public static void addNewVilla(){
        List<Villa>listVillas=new ArrayList<>();
        System.out.println("Enter id s:");
        String id=input.nextLine();
        System.out.println("Enter servicesName s:");
        String servicesName=input.nextLine();
        System.out.println("Enter Use Area D:");
        double useArea=input.nextDouble();
        System.out.println("Enter Rental Costs D:");
        double rentalCosts=input.nextDouble();
        System.out.println("Enter Maximum Guest I:");
        input.nextLine();
        int maximumGuest=Integer.parseInt(input.nextLine());
        System.out.println("Enter Rental Option S:");
        String rentalOption=input.nextLine();
        System.out.println("Enter Room Standard S:");
        String roomStandard=input.nextLine();
        System.out.println("Enter Describe Utilities S:");
        String describeUtilities=input.nextLine();
        System.out.println("Enter Area pool D:");
        double areaPool=input.nextDouble();
        System.out.println("Enter Number Of Floors I:");
        input.nextLine();
        int numberOfFloors=Integer.parseInt(input.nextLine());
        Villa villa=new Villa(id,servicesName,useArea,rentalCosts,maximumGuest,rentalOption,roomStandard,describeUtilities,areaPool,numberOfFloors);
        listVillas.add(villa);
        IOTextFileOfVillaImpl w=new IOTextFileOfVillaImpl();
        w.writeFile("D:\\C0221G1-hoangphamdon1\\Module02\\FuramaResort\\src\\Data\\villa.csv",listVillas,true);
    }
}
