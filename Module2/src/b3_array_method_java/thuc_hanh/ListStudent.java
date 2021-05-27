package b3_array_method_java.thuc_hanh;

import java.util.Scanner;

public class ListStudent {
    public static void main(String[] args) {
        String[]student={"Christian","Michael","Camila","Sienna","Tanya"};
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a name's student:");
        String input_name=scanner.nextLine();
        boolean isExist=false;
        for (int i=0;i<student.length;i++){
            if(student[i].equals(input_name)){
                System.out.println("Position of the student in the list "+ input_name +" is "+ (i+1));
                isExist=true;
                break;

            }
        }if (!isExist){
            System.out.println("Not found"+ input_name +"in the list.");
        }
    }
}
