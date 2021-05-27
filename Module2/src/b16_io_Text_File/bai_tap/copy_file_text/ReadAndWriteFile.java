package b16_io_Text_File.bai_tap.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static List<Integer>readFile(String filePath){
        List<Integer> list=new ArrayList<>();
        try{
            File file =new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br=new BufferedReader(new FileReader(file));
            String line="";
            while ((line=br.readLine())!=null){
                list.add(Integer.parseInt(line));
            }br.close();
        }catch (Exception e){
            System.out.println("Fie không tồn tại or nội dung có lỗi!");
        }return list;
    }public void writeFile(String filePath){
        try {
            FileWriter writer=new FileWriter(filePath,true);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            bufferedWriter.write("file copy");
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
