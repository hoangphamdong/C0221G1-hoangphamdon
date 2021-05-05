package Commons.impl;

import Commons.IOTextI.IOTextFileOfRoom;
import Models.House;
import Models.Room;
import Models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOTextFileOfRoomImpl implements IOTextFileOfRoom {
    @Override
    public void writeFile(String path, List<Room> list, boolean b) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Room t : list) {
                bw.write(t.toString());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Room> readFile(String path, boolean b) {
        List<Room> rooms= new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return rooms;

    }
}
