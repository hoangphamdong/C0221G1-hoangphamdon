package quanLyDanhBa.comom;

import hhhh.common.StringUint;
import model.Customer;
import model.CustomerNN;
import model.CustomerVN;
import quanLyDanhBa.model.DanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoFile {
    private static final String PATH = "src/quanLyDanhBa/data/";

    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static void writeFile(String fileName, List<DanhBa> list, boolean writeStatus) {
        File file = new File(PATH + fileName);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, writeStatus));
            for (DanhBa danhBa : list) {
                bufferedWriter.write(danhBa.toString());
                bufferedWriter.newLine();
            }


        } catch (IOException e) {
            System.out.println("Error in writing........!");
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<DanhBa> readFile(String fileName) {
        List<DanhBa> danhBaList = new ArrayList<>();

        File file = new File(PATH + fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] temp;
            DanhBa danhBa = null;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");

                danhBa = new DanhBa(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);

                danhBaList.add(danhBa);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error read file.....!");
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return danhBaList;

    }
}
