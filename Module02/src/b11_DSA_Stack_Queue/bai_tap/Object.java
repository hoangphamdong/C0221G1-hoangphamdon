package b11_DSA_Stack_Queue.bai_tap;
import java.sql.SQLOutput;
import java.util.*;
public class Object {
    public static void main(String[] args) {
        Person person1=new Person("hoang dong","nam","30/01/2002");
        Person person2=new Person("trang","nu","20/06/1966");
        Person person3=new Person("huynh","nam","7/01/1998");
        List<Person> list=new ArrayList<>();
        list.add(0,person1);
        list.add(1,person2);
        list.add(2,person3);
        Queue<Person> NU=new LinkedList<>();
        Queue<Person> NAM=new LinkedList<>();
        Queue<Person> KQ=new LinkedList<>();
        int size=list.size();
        for(int i=0;i<size;i++){
            if(list.get(i).getGender().equals("nu")){
                NU.add(list.get(i));
            }
            if(list.get(i).getGender().equals("nam")){
                NAM.add(list.get(i));
            }
        }
        int sizeNu=NU.size();
        int sizeNam=NAM.size();
        int sizeKQ=KQ.size();
        for(int i=0;i<sizeNu;i++){
            KQ.add(NU.remove());
        }
        for (int i=0;i<sizeNam;i++){
            KQ.add(NAM.remove());
        }
        System.out.println("list before:");
        System.out.println(list);
        System.out.println("List After:");
        System.out.println(KQ);


    }


}
