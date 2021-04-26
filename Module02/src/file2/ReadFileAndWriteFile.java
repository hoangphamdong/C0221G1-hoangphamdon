package file2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileAndWriteFile {
    public static List<String> readFile(String filePath) {
        List<String> strings = new ArrayList<>();
        try {

            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strings;
    }

    public static void writeFile(String filePath, List<String> stringList) {
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String[] temp;
            for (String line :
                    stringList) {
                temp = line.split(",");
                bufferedWriter.write(temp[4] + "," + temp[5]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
