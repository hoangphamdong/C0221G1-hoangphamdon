package b16_io_Text_File.bai_tap.copy_file_text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("D:\\C0221G1-hoangphamdon1\\Module02\\src\\b16_io_Text_File\\bai_tap\\copy_file_text\\readFile");
            FileWriter fileWriter = new FileWriter("D:\\C0221G1-hoangphamdon1\\Module02\\src\\b16_io_Text_File\\bai_tap\\copy_file_text\\copyFile");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line =null;
            while ((line = bufferedReader.readLine())!=null){
                bufferedWriter.write(line+"\n");
            }
            System.out.println("finish");
            bufferedReader.close();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
