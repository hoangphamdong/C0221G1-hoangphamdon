package b11_DSA_Stack_Queue.bai_tap;

public class Person {
    private String name="name";
    private String gender="gender";
    private String birdDay="birdDay";

    public Person() {
    }

    public Person(String name, String gender, String birdDay) {
        this.name = name;
        this.gender = gender;
        this.birdDay = birdDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirdDay() {
        return birdDay;
    }

    public void setBirdDay(String birdDay) {
        this.birdDay = birdDay;
    }

    @Override
    public String toString() {
        return "{ "
                +"name='" + name + '\''
                +", gender='" + gender + '\''
                +", birdDay='" + birdDay + '\''
                +'}'+"\n";
    }
}
