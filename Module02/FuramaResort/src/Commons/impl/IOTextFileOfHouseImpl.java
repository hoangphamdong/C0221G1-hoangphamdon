package Commons.impl;

import Commons.IOTextI.IOTextFileOfHouse;
import Models.House;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOTextFileOfHouseImpl implements IOTextFileOfHouse {
    @Override
    public void writeFile(String path, List<House> list, boolean b) {
        try {
            File file =new File(path);
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fileWriter);
            for (House t : list) {
                bw.write(t.toString());
            }bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<House> readFile(String path, boolean b) {
        List<House> houses = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            while ((line = br.readLine())!=null) {
//                String[] strings = line.split(",");
//                houses.add(new House(strings[0],strings[1],strings[2],strings[3],strings[4],))
                System.out.println(line);
            }br.close();
        }catch (IOException e) {
            System.out.println(e);
        }
        return houses;
    }
}
