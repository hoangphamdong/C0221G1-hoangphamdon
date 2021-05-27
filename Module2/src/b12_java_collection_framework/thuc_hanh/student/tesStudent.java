package b12_java_collection_framework.thuc_hanh.student;

import b12_java_collection_framework.thuc_hanh.student.AgeComparator;
import b12_java_collection_framework.thuc_hanh.student.Student1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tesStudent {
    public static void main(String[] args) {
        Student1 student1=new Student1("Kien",30,"HN");
        Student1 student2=new Student1("nam",26,"HN");
        Student1 student3=new Student1("Anh",38,"HN");
        Student1 student4=new Student1("Tung",38,"HN");
        List<Student1> lists=new ArrayList<Student1>();
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        lists.add(student4);
        for (Student1 st :lists){
            System.out.println(st.toString());
        }
        AgeComparator ageComparator=new AgeComparator();
        Collections.sort(lists,ageComparator);
        System.out.println("So sanh theo tuoi:");
        for (Student1 st : lists){
            System.out.println(st.toString());
        }
    }
}
