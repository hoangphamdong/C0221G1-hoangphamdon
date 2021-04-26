package FuramaResort.Models;

public abstract class Services {
    private String ID;
    private String servicesName;
    private String areaUsed;
    private double rentalCosts;
    private int maximumPeople;
    private String rentalType;

    public Services() {
    }

    public Services(String ID, String servicesName, String areaUsed, double rentalCosts, int maximumPeople, String rentalType) {
        this.ID = ID;
        this.servicesName = servicesName;
        this.areaUsed = areaUsed;
        this.rentalCosts = rentalCosts;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
    }

    public abstract  String showInFor();
}
