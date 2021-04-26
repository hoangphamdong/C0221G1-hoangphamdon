package file;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       String list;
       list=WriteFile.readFile("D:\\C0221G1-hoangphamdon1\\Module02\\src\\file\\sourd");
       WriteFile.writeFile("D:\\C0221G1-hoangphamdon1\\Module02\\src\\file\\copy",list);
    }
}
