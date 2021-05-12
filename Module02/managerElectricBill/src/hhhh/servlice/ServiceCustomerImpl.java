package servlice;

import common.IoFile;
import common.StringUint;
import common.Validator;
import model.Customer;
import model.CustomerNN;
import model.CustomerVN;
import model.InformationBill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceCustomerImpl implements ServiceCustomer {
    private Scanner input = new Scanner(System.in);

    @Override
    public void addNewCustomer(String fileName) {

        List<Customer> customerList = new ArrayList<>();
        Customer customer = null;

        String customerCode = null;
        if (fileName.equals(StringUint.CUSTOMER_VN)) {
            do {
                System.out.print("Nhập mã khách hàng:");
                System.out.println("KHVN-XXXXX");
                customerCode = input.nextLine();
            } while (!Validator.isValidRegex(customerCode, Validator.CODE_CUSTOMER_VN));
        } else if (fileName.equals(StringUint.CUSTOMER_NN)) {
            do {
                System.out.print("Nhập mã khách hàng:");
                customerCode = input.nextLine();
                System.out.println("KHNN-XXXXX");
            } while (Validator.isValidRegex(customerCode, Validator.CODE_CUSTOMER_NN));
        }

        System.out.print("Nhập họ tên khách hàng");
        String customerName = input.nextLine();

        if (fileName.equals(StringUint.CUSTOMER_VN)) {


            System.out.println("Danh sách loại khách hang:");
            List<String> stringList = IoFile.readFileString("loaiKhach.csv");
            for (String line : stringList) {
                System.out.println(line.toString());
            }

            String customerType = null;
            do {
                System.out.print("Nhập loại khách hàng:");
                customerType = input.nextLine();
            } while (!Validator.isValidRegex(customerType, Validator.Type_CUSTOMER));

            System.out.print("Nhập định mức tiêu thụ:");
            double consumptionNorms = Double.parseDouble(input.nextLine());

            customer = new CustomerVN(customerCode, customerName, customerType, consumptionNorms);
            customerList.add(customer);
            IoFile.writeFile(fileName, customerList, true);
            System.out.println();

        } else if (fileName.equals(StringUint.CUSTOMER_NN)) {
            System.out.print("nhập quốc tịch:");
            String nationality = input.nextLine();

            customer = new CustomerNN(customerCode, customerName, nationality);
            customerList.add(customer);
            IoFile.writeFile(fileName, customerList, true);
            System.out.println();


        }
    }

    @Override
    public void showInformationCustomer(String fileName) {
        System.out.println("Danh sách khách hàng:");
        List<Customer> list = IoFile.readFile(fileName);
        for (Customer line : list) {
            line.ShowInfo();
        }
        System.out.println("---------------------------------");
    }

    @Override
    public void search(String fileName) {
        System.out.println("Nhập tên cần tìm:");
        String customerName = input.nextLine();
        boolean flag = false;
        List<Customer> listCustomerVn = IoFile.readFile("khachHangVN.csv");
        for (int i = 0; i < listCustomerVn.size(); i++) {
            if (listCustomerVn.get(i).getCustomerName().equals(customerName)) {
                System.out.println("Thông tin khách hàng");
                System.out.println(listCustomerVn.get(i).toString());
                System.out.println("---------------------------------------");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("không tìm thấy");
        }
    }

    @Override
    public void addNewBill() {
        List<Customer> listCustomerVN = IoFile.readFile("khachHangVN.csv");
        List<InformationBill> bills = new ArrayList<>();
        System.out.println("Danh sach khach hàng Việt Nam");
        for (Customer customer : listCustomerVN) {
            System.out.println(customer.toString());
        }
        System.out.println("---------------------------------------");
        List<Customer> listCustomerNN = IoFile.readFile("khachHangNN.csv");
        System.out.println("Danh sach khach hàng Nước ngoài");
        for (Customer customer : listCustomerNN) {
            System.out.println(customer.toString());
        }
        System.out.println("---------------------------------------");
        List<InformationBill> billList = IoFile.readFileBill("hoaDon.csv");
        String codeBill = "MHD-";
        int id = -1;
        String str;
        if (billList.isEmpty()) {
            id = 1;
            str = String.valueOf(id);
            codeBill.concat(str);
        } else {

            String[] temp = billList.get(billList.size() - 1).getCodeBill().split("-");
            id = Integer.parseInt(temp[2]) + 1;
            str = String.valueOf(id);
            codeBill.concat(str);
        }
        System.out.print("Nhập mã khách hàng:");
        String codeCustomer = input.nextLine();

        System.out.println("Nhập ngày xuất hóa đơn");
        String dataBill = input.nextLine();

        System.out.println("Nhập số lượng:");
        double amount = Double.parseDouble(input.nextLine());

        System.out.println("Nhập đơn giá:");
        double unitPrice = Double.parseDouble(input.nextLine());

        System.out.println("Thành tiền:");
        double intoMoney = amount * unitPrice;

        InformationBill informationBill = new InformationBill(codeBill, codeCustomer, dataBill, amount, unitPrice, intoMoney);
        bills.add(informationBill);
        IoFile.writeFileBill("hoaDon.csv",bills,true);


    }

}
//    public void addNewProduct() {
//        List<Product> productList = IoFile.readFile("product.csv");
//        int id = -1;
//        if (productList.isEmpty()) {
//            id = 1;
//        } else {
//            id = productList.get(productList.size() - 1).getId() + 1;
//        }
//
//        System.out.println("Enter Name:");
//        String name = input.nextLine();
//
//        System.out.println("Enter amount:");
//        double amount = Double.parseDouble(input.nextLine());
//
//
//        productList.add(new Product(id, name, amount));
//        IoFile.writerFile("product.csv", productList, false);
//    }

