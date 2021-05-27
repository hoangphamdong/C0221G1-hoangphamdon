package b16_io_Text_File.thuc_hanh.tinh_tong_cac_so_trong_file;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public static void redFileText(String filePath){
        try{
            File file =new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br=new BufferedReader(new FileReader(file));
            String line="";
            int sum=0;
            while((line=br.readLine())!=null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }
            br.close();
            System.out.println("Tổng= "+sum);
        }catch (Exception e){
            System.out.println("fie không tồn tại or nội dung có lỗi!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner input=new Scanner(System.in);
        String path=input.nextLine();
        redFileText(path);
    }
}
