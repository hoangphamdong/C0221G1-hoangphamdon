package managerProduct.commons;

public class StringUtils {
    public static final String CSV="csv";
    public static final String COMMA=",";

    public static String concat(String[] content,String character){
        StringBuffer outStr=new StringBuffer(content[0]);
        for(int i=1;i<content.length;i++){
            outStr.append(character);
            outStr.append(content[1]);
        }return outStr.toString();
    }
}
