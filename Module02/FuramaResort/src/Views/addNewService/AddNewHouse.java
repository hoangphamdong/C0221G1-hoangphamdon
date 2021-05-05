package Views.addNewService;

import Commons.IOTextI.IOTextFileOfHouse;
import Commons.impl.IOTextFileOfHouseImpl;
import Models.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNewHouse {
    static Scanner input=new Scanner(System.in);
public static void addNewHouse(){
    List<House> houseList=new ArrayList<>();
    System.out.println("Enter id S:");
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
    System.out.println("Enter roomStandard S: ");
    String roomStandard=input.nextLine();
    System.out.println("Enter Describe Utilities S:");
    String describeUtilities=input.nextLine();
    System.out.println("Enter number of floors I:");
    int numberOfFloors=Integer.parseInt(input.nextLine());
    House house=new House(id,servicesName,useArea,rentalCosts,maximumGuest,rentalOption,roomStandard,describeUtilities,numberOfFloors);
    houseList.add(house);
    IOTextFileOfHouse fileOfHouse= new IOTextFileOfHouseImpl();
    fileOfHouse.writeFile("src/Data/house.csv",houseList,true);
}
}
