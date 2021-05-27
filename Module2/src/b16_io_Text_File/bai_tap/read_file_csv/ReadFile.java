package b16_io_Text_File.bai_tap.read_file_csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadFile {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("D:\\C0221G1-hoangphamdon1\\Module02\\src\\b16_io_Text_File\\bai_tap\\read_file_csv\\file");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line =null;
            while ((line = bufferedReader.readLine())!=null){
                String[]qg=line.split(",");
                System.out.println("Quốc gia "+qg[1]+"name"+qg[2]+"chỉ số "+qg[0]);
            }
            System.out.println("finish");
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
