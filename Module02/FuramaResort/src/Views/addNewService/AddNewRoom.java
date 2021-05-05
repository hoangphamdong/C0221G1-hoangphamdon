package Views.addNewService;

import Commons.IOTextI.IOTextFileOfRoom;
import Commons.impl.IOTextFileOfRoomImpl;
import Models.Room;
import Models.Villa;
import Models.includedFreeService.IncludedFreeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNewRoom {
    public static void addNewRoom(){
        Scanner input=new Scanner(System.in);
        List<Room> listRoom=new ArrayList<>();
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
        try{
            int choice;
            System.out.println("chọn dịch vụ đi kèm:\n" +
                    "1.karaoke\n" +
                    "2.massage\n" +
                    "3.food\n" +
                    "4.drink\n" +
                    "5.car" +
                    "6.ext.");
            System.out.println("Enter choice:");
            choice=Integer.parseInt(input.nextLine());
            if(choice<1||choice>6){
                System.out.println("Vui lòng nhập từ 1-->6.");
            }
            else {
                switch (choice){
                    case 1:
                        String name="Karaoke";
                        System.out.println("Nhập số lượng");
                        int amount=Integer.parseInt(input.nextLine());
                        System.out.println("Nhập đơn giá");
                        double price=input.nextDouble();
                        IncludedFreeService karaoke=new IncludedFreeService(name,amount,price);
                        Room room=new Room(id,servicesName,useArea,rentalCosts,rentalCosts,maximumGuest,rentalOption,karaoke);
                        listRoom.add(room);
                        IOTextFileOfRoomImpl fileOfRoom=new IOTextFileOfRoomImpl();
                        fileOfRoom.writeFile("src/Data/room.csv",listRoom,true);
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Nhập số nguyên..!");
        }

    }

}
