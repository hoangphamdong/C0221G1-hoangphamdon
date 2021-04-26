package FuramaResort.Models;

public class Room extends Services{
    private  String servicesFree;

    public Room() {
    }

    public Room(String servicesFree) {
        this.servicesFree = servicesFree;
    }

    public Room(String ID, String servicesName, String areaUsed, double rentalCosts, int maximumPeople, String rentalType, String servicesFree) {
        super(ID, servicesName, areaUsed, rentalCosts, maximumPeople, rentalType);
        this.servicesFree = servicesFree;
    }

    public String getServicesFree() {
        return servicesFree;
    }

    public void setServicesFree(String servicesFree) {
        this.servicesFree = servicesFree;
    }

    @Override
    public String showInFor() {
        return null;
    }
}
