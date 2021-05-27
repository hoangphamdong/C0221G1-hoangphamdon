package baiTapLamThem.commons;

import baiTapLamThem.models.PhuongTienGiaoThong;
import managerProduct.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static String path;

    public static void setFullPathFile(String fileName){
        StringBuffer path=new StringBuffer("src/baiTapLamThem/data/");
        path.append(fileName);
        path.append(StringUtils.CSV);
        FileUtils.path=path.toString();
    }


    public static void writeFile(String[] content){
        try {
            bufferedWriter=new BufferedWriter(new FileWriter(path,true));
            bufferedWriter.write(StringUtils.concat(content,StringUtils.COMMA));
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<String> readFile(){
        List<String>arrayContent=new ArrayList<>();

        try {
            bufferedReader=new BufferedReader(new FileReader(path));
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                arrayContent.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return  arrayContent;
    }
}
