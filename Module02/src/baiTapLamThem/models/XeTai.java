package baiTapLamThem.models;

public class XeTai extends PhuongTienGiaoThong {
    private int trongTai;

    public XeTai() {
    }

    public XeTai(int trongTai) {
        this.trongTai = trongTai;
    }

    public XeTai(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String choSoHuu, int trongTai) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, choSoHuu);
        this.trongTai = trongTai;
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTai{" +
                "trongTai=" + trongTai +
                '}'+super.toString();
    }

    @Override
    public void ShowInfo() {
        System.out.println(this.toString());
    }
}
