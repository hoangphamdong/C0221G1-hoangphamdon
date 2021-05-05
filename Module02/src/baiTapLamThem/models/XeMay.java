package baiTapLamThem.models;

public class XeMay extends PhuongTienGiaoThong {
    private int congSuat;

    public XeMay() {
    }

    public XeMay(int congSuat) {
        this.congSuat = congSuat;
    }

    public XeMay(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String choSoHuu, int congSuat) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, choSoHuu);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMay{" +
                "congSuat=" + congSuat +
                '}'+super.toString();
    }

    @Override
    public void ShowInfo() {
        System.out.println(this.toString());
    }
}
