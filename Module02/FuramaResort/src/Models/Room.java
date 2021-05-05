package Models;

import Models.includedFreeService.IncludedFreeService;

public class Room extends Services {
    private IncludedFreeService includedFreeService;

    public Room() {
    }

    public Room(IncludedFreeService includedFreeService) {
        this.includedFreeService = includedFreeService;
    }

    public Room(String id, String servicesName, double useArea, double rentalCosts, int maximumGuest, String rentalOption, IncludedFreeService includedFreeService) {
        super(id, servicesName, useArea, rentalCosts, maximumGuest, rentalOption);
        this.includedFreeService = includedFreeService;
    }

    public Room(String id, String servicesName, double useArea, double rentalCosts, double rentalCosts1, int maximumGuest, String rentalOption, IncludedFreeService karaoke) {
    }

    public IncludedFreeService getIncludedFreeService() {
        return includedFreeService;
    }

    public void setIncludedFreeService(IncludedFreeService includedFreeService) {
        this.includedFreeService = includedFreeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "includedFreeService='" + includedFreeService + '\'' +
                '}';
    }

    @Override
    public String showInFor() {
        return "includedFreeService "+getIncludedFreeService();
    }
}
