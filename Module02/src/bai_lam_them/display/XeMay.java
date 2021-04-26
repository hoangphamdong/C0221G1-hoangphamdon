package bai_lam_them.display;

import bai_lam_them.display.PhuongTienGiaoThong;

public class XeMay extends PhuongTienGiaoThong {
    private String CongXuat;

    public XeMay() {
    }

    public XeMay(String congXuat) {
        CongXuat = congXuat;
    }

    public XeMay(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, String congXuat) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        CongXuat = congXuat;
    }

    public String getCongXuat() {
        return CongXuat;
    }

    public void setCongXuat(String congXuat) {
        CongXuat = congXuat;
    }
}
