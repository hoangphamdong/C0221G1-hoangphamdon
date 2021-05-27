package furamaResort.Controllers;

import furamaResort.Commons.ConvertUtils;
import furamaResort.Commons.FileUtils;
import furamaResort.Commons.StringUtils;
import furamaResort.Commons.Validators;
import furamaResort.Exception.*;
import furamaResort.Models.*;

import java.util.*;

public class MainControllers {
    private static Scanner input = new Scanner(System.in);
    private static boolean isExit;
    private static String VILLA = "villa";
    private static String HOUSE = "house";
    private static String ROOM = "room";
    private static String CUSTOMER = "customer";
    private static boolean isBackToMenu;


    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int choose = 0;
        do {
            System.out.println("Main Menu:\n" +
                    "1.\t Add New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit.\n" +
                    "8.\tShow Queue of Customer");
            System.out.println("Enter your Choose:");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer(CUSTOMER);
                case 4:
                    showInformationOfCustomer(CUSTOMER);
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmployee();
                    break;
                case 7:
                    System.out.println("you had Exit..!");
                    isExit = true;
                    break;
                case 8:
                    showQueueOfCustomers();
                    break;
            }
            if (isExit) {
                break;
            }
        } while (choose >= 1 && choose <= 8);
    }

    private static void showQueueOfCustomers() {
        Queue<Customer> queueCustomer = new LinkedList<>();
        List<Customer> listOfCustomers = readAllCustomer(CUSTOMER);

        showInformationOfCustomer(CUSTOMER);

        queueCustomer.add(listOfCustomers.get(3));
        queueCustomer.add(listOfCustomers.get(5));
        queueCustomer.add(listOfCustomers.get(1));

        Customer customer = null;

        System.out.println("-----------------------");
        System.out.println("List customer who by ticket:");
        while (!queueCustomer.isEmpty()) {
            customer = queueCustomer.poll();
            customer.showInFor();
        }
    }

    private static void showInformationOfEmployee() {
    }

    private static void addNewBooking() {
        List<Customer>listOfCustomer=readAllCustomer(CUSTOMER);
        showInformationOfCustomer(CUSTOMER);
        System.out.println("Please choose customer to booking:");
        int iCustomer=input.nextInt();
    }

    private static List<Customer> readAllCustomer(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesCustomer = FileUtils.readFile();
        List<Customer> lisOfCustomer = new ArrayList<>();
        String[] arrPropertyCustomer = null;
        Customer customer = null;
        for (String properties : propertiesCustomer) {
            arrPropertyCustomer = properties.split(StringUtils.COMMA);
            customer = new Customer();
            customer.setFullName(arrPropertyCustomer[0]);
            customer.setDateOfBirth(arrPropertyCustomer[1]);
            customer.setGender(arrPropertyCustomer[2]);
            customer.setIdCard(arrPropertyCustomer[3]);
            customer.setPhoneNumber(arrPropertyCustomer[4]);
            customer.setEmail(arrPropertyCustomer[5]);
            customer.setTypeOfCustomer(arrPropertyCustomer[6]);
            customer.setAddress(arrPropertyCustomer[7]);
            lisOfCustomer.add(customer);
        }
        return lisOfCustomer;
    }

    private static void showInformationOfCustomer(String fineName) {
        System.out.println("-----------------------------------");
        System.out.println("List Customer..");

        List<Customer> listOfCustomer = readAllCustomer(fineName);
        Collections.sort(listOfCustomer);

        Customer customer = null;
        for (int i = 0; i < listOfCustomer.size(); i++) {
            customer = listOfCustomer.get(i);
            System.out.print((i + 1) + ". ");
            customer.showInFor();
        }

    }

    private static void addNewCustomer(String fineName) {

        input.nextLine();
        boolean flag;
        String fullName = null;
        do {
            flag = true;
            System.out.println("Please input full name: ");
            fullName = input.nextLine();
            try {
                Validators.isValidFullName(fullName);
            } catch (NameException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);

        String dateOfBirth = null;
        do {
            flag = true;
            System.out.println("Please input date of birth: ");
            dateOfBirth = input.nextLine();
            try {
                Validators.isValidBirthday(dateOfBirth);
            } catch (BirthdayException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);

        String gender = null;
        do {
            System.out.println("Please input gender: ");
            gender = input.nextLine();
            try {
                Validators.isValidGender(gender);
            } catch (GanderException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);

        gender = ConvertUtils.normalizeStr(gender);

        String idCard = null;
        do {
            flag = true;
            System.out.println("Please input id card: ");
            idCard = input.nextLine();
            try {
                Validators.isValidCard(idCard);
            } catch (IdCardException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);

        System.out.println("Please input number phone: ");
        String numberPhone = input.nextLine();

        String email = null;
        do {
            flag = true;
            System.out.println("Please input email: ");
            email = input.nextLine();
            try {
                Validators.isValidEmail(email);
            } catch (EmailException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);

        System.out.println("Please input type of customer: ");
        String typeOfCustomer = input.nextLine();

        System.out.println("Please input address: ");
        String address = input.nextLine();

        FileUtils.setFullPathFile(fineName);
        FileUtils.writerFile(new String[]{fullName, dateOfBirth, gender, idCard, numberPhone, email, typeOfCustomer, address});
    }


    private static void addNewServices() {
        int choose = 0;
        do {
            System.out.println("Menu Add New Services:\n" +
                    "1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit. ");
            System.out.println("Enter Your Choose:");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    addNewService(VILLA);
                    isBackToMenu = false;
                    break;
                case 2:
                    addNewService(HOUSE);
                    isBackToMenu = false;
                    break;
                case 3:
                    addNewService(ROOM);
                    isBackToMenu = false;
                    break;
                case 4:
                    isBackToMenu = true;
                    break;
                case 5:
                    isExit = true;
                    break;
            }
            if (isBackToMenu || isExit) {
                return;
            }
        } while (choose >= 1 && choose <= 5);
    }

    private static void addNewService(String fileName) {
        String id;
        do {
            input.nextLine();
            System.out.println("Please input service id: ");
            id = input.nextLine();
        } while (!Validators.isValidRegex(id, Validators.SERVICE_CODE_REGEX));

        String serviceName;
        do {
            System.out.println("Please input service name: ");
            serviceName = input.nextLine();
        } while (!Validators.isValidRegex(serviceName, Validators.SERVICE_NAME_REGEX));

        double areaUse = 0;
        do {
            System.out.println("Please input area use: ");
            areaUse = input.nextDouble();
        } while (!Validators.isMoreThan(areaUse, 30));

        double rentCost = 0;
        do {
            System.out.println("Please input rent cost:");
            rentCost = input.nextDouble();
        } while (Validators.isMoreThan(rentCost, 30));

        int numberOfPeople = 0;
        do {
            System.out.println("Please input number of people: ");
            numberOfPeople = input.nextInt();
        } while (Validators.isMoreThan(numberOfPeople, 0, 20));

        String typeRent;
        do {
            input.nextLine();
            System.out.println("Please input type rent: ");
            typeRent = input.nextLine();
        } while (Validators.isValidRegex(typeRent, Validators.SERVICE_NAME_REGEX));

        FileUtils.setFullPathFile(fileName);
        if (fileName.equals(VILLA)) {

            String standardRoom;
            do {
                System.out.println("Please input standard room:");
                standardRoom = input.nextLine();
            } while (Validators.isValidRegex(standardRoom, Validators.SERVICE_NAME_REGEX));

            System.out.println("Please input other description:");
            String otherDescription = input.nextLine();

            double areaPool = 0;
            do {
                System.out.println("Please input area pool:");
                areaPool = input.nextDouble();
            } while (Validators.isMoreThan(areaPool, 30));

            int numberOfFloors = 0;
            do {
                System.out.println("Please input number of floors:");
                numberOfFloors = input.nextInt();
            } while (Validators.isMoreThan(numberOfPeople, 0));

            FileUtils.writerFile(new String[]{id, serviceName, String.valueOf(areaUse), String.valueOf(rentCost), String.valueOf(numberOfPeople), typeRent,
                    standardRoom, otherDescription, String.valueOf(areaPool), String.valueOf(numberOfFloors)});
        } else if (fileName.equals(HOUSE)) {
            System.out.println("Please input standard room:");
            String standardRoom = input.nextLine();

            System.out.println("Please input other description:");
            String otherDescription = input.nextLine();

            int numberOfFloors = 0;
            do {
                System.out.println("Please input number of floors:");
                numberOfFloors = input.nextInt();
            } while (Validators.isMoreThan(numberOfFloors, 0));
            FileUtils.writerFile(new String[]{id, serviceName, String.valueOf(areaUse), String.valueOf(rentCost), String.valueOf(numberOfPeople), typeRent,
                    standardRoom, otherDescription, String.valueOf(numberOfFloors)});
        } else if (fileName.equals(ROOM)) {

            String extraServiceName;
            do {
                System.out.println("karaoke||massage||food||car.");
                System.out.println("Please input extra service name: ");
                extraServiceName = input.nextLine();
            } while (Validators.isValidExtraServiceName(extraServiceName));

            System.out.println("Please input unit: ");
            String unit = input.nextLine();

            System.out.println("Please input money: ");
            double money = input.nextDouble();

            FileUtils.writerFile(new String[]{id, serviceName, String.valueOf(areaUse), String.valueOf(rentCost), String.valueOf(numberOfPeople), typeRent,
                    extraServiceName, unit, String.valueOf(money)});
        }
    }

    public static void showServices() {
        int choose = 0;
        do {
            System.out.println("Menu Add New Services:\n" +
                    "1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Name Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit. ");
            System.out.println("Enter Your Choose:");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    showAllServices(VILLA);
                    isBackToMenu = false;
                    break;
                case 2:
                    showAllServices(HOUSE);
                    isBackToMenu = false;
                    break;
                case 3:
                    showAllServices(ROOM);
                    isBackToMenu = false;
                    break;
                case 4:
                    showAllVillaNotDuplicate(VILLA);
                    isBackToMenu = true;
                    break;
                case 5:
                    showAllVillaNotDuplicate(HOUSE);
                    isBackToMenu = true;
                    break;
                case 6:
                    showAllVillaNotDuplicate(ROOM);
                    isBackToMenu = true;
                    break;
                case 7:
                    isBackToMenu = true;
                    break;
                case 8:
                    isExit = true;
                    break;
            }
            if (isBackToMenu || isExit) {
                return;
            }
        } while (choose >= 1 && choose <= 8);
    }

    public static List<Services> readAllServices(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesService = FileUtils.readFile();
        List<Services> lisOfServices = new ArrayList<>();
        String[] propertiesElement = null;

        Services services = null;
        ExtraService extraService = null;

        for (String properties : propertiesService) {
            propertiesElement = properties.split(StringUtils.COMMA);
            if (fileName.equals(VILLA)) {
                services = new Villa();
                ((Villa) services).setStandardRoom(propertiesElement[6]);
                ((Villa) services).setOtherDescription(propertiesElement[7]);
                ((Villa) services).setAreaPool(propertiesElement[8]);
                ((Villa) services).setNumberOfFloors(Integer.parseInt(propertiesElement[9]));
            } else if (fileName.equals(HOUSE)) {
                services = new House();
                ((House) services).setStandardRoom(propertiesElement[6]);
                ((House) services).setOtherDescription(propertiesElement[7]);
                ((House) services).setNumberOfFloors(Integer.parseInt(propertiesElement[8]));
            } else if (fileName.equals(ROOM)) {
                extraService = new ExtraService(propertiesElement[6], propertiesElement[7], Double.parseDouble(propertiesElement[8]));
                services = new Room();
                ((Room) services).setExtraSerVice(extraService);
            }
            services.setId(propertiesElement[0]);
            services.setServiceName(propertiesElement[1]);
            services.setAreaUse(Double.parseDouble(propertiesElement[2]));
            services.setRenCost(Double.parseDouble(propertiesElement[3]));
            services.setNumberOfPeoples(Integer.parseInt(propertiesElement[4]));
            services.setTypeRent(propertiesElement[5]);
            lisOfServices.add(services);

        }
        return lisOfServices;
    }

    private static void showAllVillaNotDuplicate(String fileName) {
        Set<String> setOfServices = new TreeSet<>();
        System.out.println("-----------------------");
        System.out.println("List services not duplicate name: ");
        for (Services services : readAllServices(fileName)) {
            setOfServices.add(services.getServiceName());
        }
        for (String name : setOfServices) {
            System.out.println(name);
        }
    }

    private static void showAllServices(String fileName) {
        System.out.println("----------------------------------");
        System.out.println("List services: ");

        List<Services> listOfServices = readAllServices(fileName);
        Services services = null;
        for (int i = 0; i < listOfServices.size(); i++) {
            services = listOfServices.get(i);
            System.out.println((i + 1)+". ");

            services.showInFor();
        }
    }
}

