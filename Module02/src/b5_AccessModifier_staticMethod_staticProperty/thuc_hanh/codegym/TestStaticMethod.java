package b5_AccessModifier_staticMethod_staticProperty.thuc_hanh.codegym;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1 =new Student(111,"Hoang");
        s1.display();
    }
}
