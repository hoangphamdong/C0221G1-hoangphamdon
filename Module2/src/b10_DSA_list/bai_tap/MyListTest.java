package b10_DSA_list.bai_tap;

public class MyListTest {
    public static class Student{
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a=new Student(1,"dong");
        Student b=new Student(2,"huynh");
        Student c=new Student(3,"vu");
        Student d=new Student(4,"trang");
        Student e=new Student(5,"hoang");
        Student f=new Student(6,"tho");
        MyList<Student>studentMyList=new MyList<>();
        studentMyList.add(a);
        studentMyList.add(b);
        studentMyList.add(c);
        studentMyList.add(d);
        studentMyList.add(e);
        studentMyList.add(f,2);
        System.out.println("size: "+studentMyList.size());
        System.out.println(studentMyList.get(2).getName());
        for (int i =0;i<studentMyList.size();i++){
        Student student=(Student) studentMyList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }

    }
}
