package bai_lam_them.display;

import bai_lam_them.display.PhuongTienGiaoThong;

public class Xetai extends PhuongTienGiaoThong {
    private String trongTai;

    public Xetai() {
    }

    public Xetai(String trongTai) {
        this.trongTai = trongTai;
    }

    public Xetai(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, String trongTai) {
        super(bienKiemSoat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }
}
