package review.model;

public class Teacher extends Person {
    private String subject;

    public Teacher() {
    }

    public Teacher(String name, int age, String address, String subject) {
        super(name, age, address);
        this.subject = subject;
    }

    public Teacher(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString()+","+subject;
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}
