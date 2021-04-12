package b10_DSA_list.bai_tap;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY1 = 10;
    public Object elements[];

   public MyList() {
        elements = new Object[DEFAULT_CAPACITY1];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity "+capacity);
        }


    }

    public int size() {
        return this.size;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }

    }
    public boolean add(E element){
       if(elements.length==size){
           this.ensureCapacity(5);
       }
        elements[size]=element;
        size++;
        return  true;
    }
    public void ensureCapacity(int minCapacity){
        if(minCapacity>=0){
            int newSize=this.elements.length+minCapacity;
            elements= Arrays.copyOf(elements,newSize);

        }else{
           throw new IllegalArgumentException("minCapacity "+minCapacity);

        }
    }
    public void add(E element,int index){
       if(index>elements.length){
           throw new IllegalArgumentException("index "+index);
       }else if(elements.length==size){
           this.ensureCapacity(5);
       }
       if(elements[index]==null){
           elements[index]=element;
           size++;
       }else{
           for (int i=size+1;i>=index;i--){
               elements[i]=elements[i-1];
           }
           elements[index]=element;
           size++;
       }

    }/** phương thức lấy 1 element tại vị trí index*/
    public E get(int index){
       return (E) elements[index];
    }

}