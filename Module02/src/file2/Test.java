package file2;

import b16_io_Text_File.thuc_hanh.tim_gia_tri_lon_nhat_va_ghi_ra_file.ReadAndWriteFile;
import file.WriteFile;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<String> listLine = ReadFileAndWriteFile.readFile("D:\\C0221G1-hoangphamdon1\\Module02\\src\\file2\\sourd");

        ReadFileAndWriteFile.writeFile("D:\\C0221G1-hoangphamdon1\\Module02\\src\\file2\\copy", listLine);

    }
}
