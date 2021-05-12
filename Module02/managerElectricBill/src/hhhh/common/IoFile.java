package common;

import model.Customer;
import model.CustomerNN;
import model.CustomerVN;
import model.InformationBill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IoFile {
    private static final String PATH = "src/data/";

    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static void writeFile(String fileName, List<Customer> list, boolean writeStatus) {
        File file = new File(PATH + fileName);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, writeStatus));
            for (Customer customer : list) {
                bufferedWriter.write(customer.toString());
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

    public static void writeFileBill(String fileName, List<InformationBill> list, boolean writeStatus) {
        File file = new File(PATH + fileName);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, writeStatus));
            for (InformationBill bill : list) {
                bufferedWriter.write(bill.toString());
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

    public static List<Customer> readFile(String fileName) {
        List<Customer> customerList = new ArrayList<>();

        File file = new File(PATH + fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] temp;
            Customer customer = null;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                if (fileName.equals(StringUint.CUSTOMER_VN)) {
                    customer = new CustomerVN(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]));
                } else if (fileName.equals(StringUint.CUSTOMER_NN)) {
                    customer = new CustomerNN(temp[0], temp[1], temp[2]);
                }
                customerList.add(customer);

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
        return customerList;

    }

    public static List<String> readFileString(String fileName) {
        List<String> stringList = new ArrayList<>();

        File file = new File(PATH + fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] temp;
            Customer customer = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);

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
        return stringList;

    }

    public static List<InformationBill> readFileBill(String fileName) {
        List<InformationBill> informationBills = new ArrayList<>();

        File file = new File(PATH + fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] temp;
            InformationBill informationBill = null;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");

                informationBill = new InformationBill(temp[0], temp[1], temp[2],Double.parseDouble(temp[3]),Double.parseDouble(temp[4]),Double.parseDouble(temp[5]));

                informationBills.add(informationBill);

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
        return informationBills;

    }
}

//    public static void writeFile(String fileName, List<Vehicle> list, boolean writeStatus) {
//
//        File file = new File(PATH + fileName + CSV);
//
//        try {
//            bufferedWriter = new BufferedWriter(new FileWriter(file, writeStatus));
//            for (Vehicle vehicle : list) {
//
//                bufferedWriter.write(vehicle.toString());
//                bufferedWriter.newLine();
//
//            }
//
//        } catch (IOException e) {
//
//            System.out.println("Error in writing......!");
//            e.printStackTrace();
//
//        } finally {
//            try {
//                bufferedWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public static List<Vehicle> readFile(String fileName) {
//        List<Vehicle> vehicleList = new ArrayList<>();
//        File file = new File(PATH + fileName + CSV);
//
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            bufferedReader = new BufferedReader(new FileReader(file));
//            String line = "";
//            String[] temp = null;
//            Vehicle vehicle = null;
//            while ((line = bufferedReader.readLine()) != null) {
//                temp = line.split(",");
//                if (fileName.equals(StringUtil.TRUCK)) {
//                    vehicle = new Truck(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], Integer.parseInt(temp[4]));
//                } else if (fileName.equals(StringUtil.CAR)) {
//                    vehicle = new Car(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], temp[4], temp[5]);
//                } else if (fileName.equals(StringUtil.MOTORCYCLE)) {
//                    vehicle = new Truck(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], Integer.parseInt(temp[4]));
//                }
//                vehicleList.add(vehicle);
//
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println("Error read file.....!");
//            e.printStackTrace();
//        }
//        return vehicleList;