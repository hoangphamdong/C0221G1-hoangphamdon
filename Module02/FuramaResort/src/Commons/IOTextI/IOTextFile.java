package Commons.IOTextI;

import java.util.List;

public interface IOTextFile<T> {
     void writeFile(String path, List<T> list, boolean b);
     List<T> readFile(String path,boolean b);
}
