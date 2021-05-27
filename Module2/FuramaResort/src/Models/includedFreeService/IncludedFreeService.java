package Models.includedFreeService;

public class IncludedFreeService {
    private String nameIncluded;
    private int amount;
    private double price;

    public IncludedFreeService() {
    }

    public IncludedFreeService(String nameIncluded, int amount, double price) {
        this.nameIncluded = nameIncluded;
        this.amount = amount;
        this.price = price;
    }

    public String getNameIncluded() {
        return nameIncluded;
    }

    public void setNameIncluded(String nameIncluded) {
        this.nameIncluded = nameIncluded;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "IncludedFreeService{" +
                "nameIncluded='" + nameIncluded + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
