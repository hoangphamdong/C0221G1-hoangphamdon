package Models;

public abstract class Services {
    private String id;
    private String servicesName;
    private double useArea;
    private double rentalCosts;
    private int maximumGuest;
    private String rentalOption;

    public Services() {
    }

    public Services(String id, String servicesName, double useArea, double rentalCosts, int maximumGuest, String rentalOption) {
        this.id = id;
        this.servicesName = servicesName;
        this.useArea = useArea;
        this.rentalCosts = rentalCosts;
        this.maximumGuest = maximumGuest;
        this.rentalOption = rentalOption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumGuest() {
        return maximumGuest;
    }

    public void setMaximumGuest(int maximumGuest) {
        this.maximumGuest = maximumGuest;
    }

    public String getRentalOption() {
        return rentalOption;
    }

    public void setRentalOption(String rentalOption) {
        this.rentalOption = rentalOption;
    }
    public abstract String showInFor();

    @Override
    public String toString() {
        return  id +
                "," + servicesName + '\'' +
                "," + useArea +
                "," + rentalCosts +
                "," + maximumGuest +
                "," + rentalOption ;
    }
}
