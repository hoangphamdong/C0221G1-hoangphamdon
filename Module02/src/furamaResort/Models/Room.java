package furamaResort.Models;

/**
 * -	Riêng Phòng sẽ có thêm thông tin: Dịch vụ miễn phí đi kèm.
 */
public class Room extends Services {
    private ExtraService extraSerVice;

    public Room() {
    }

    public Room(ExtraService extraSerVice) {
        this.extraSerVice = extraSerVice;
    }

    public Room(String id, String serviceName, double areaUse, double renCost, int numberOfPeoples, String typeRent, ExtraService extraSerVice) {
        super(id, serviceName, areaUse, renCost, numberOfPeoples, typeRent);
        this.extraSerVice = extraSerVice;
    }

    public ExtraService getExtraSerVice() {
        return extraSerVice;
    }

    public void setExtraSerVice(ExtraService extraSerVice) {
        this.extraSerVice = extraSerVice;
    }

    @Override
    public String toString() {
        return "Room{" +
                "extraSerVice=" + extraSerVice +
                '}';
    }

    @Override
    public void showInFor() {
        System.out.println(this.toString());
    }
}
