package baiTapLamThem.models;

public abstract class PhuongTienGiaoThong {
    protected String bienKiemSoat;
    protected String tenHangSanXuat;
    protected int namSanXuat;
    protected String choSoHuu;

    public PhuongTienGiaoThong() {
    }

    public PhuongTienGiaoThong(String bienKiemSoat, String tenHangSanXuat, int namSanXuat, String choSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.namSanXuat = namSanXuat;
        this.choSoHuu = choSoHuu;
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChoSoHuu() {
        return choSoHuu;
    }

    public void setChoSoHuu(String choSoHuu) {
        this.choSoHuu = choSoHuu;
    }

    @Override
    public String toString() {
        //000011
        //9999
        return "PhuongTienGiaoThong{" +
                "bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", choSoHuu='" + choSoHuu + '\'' +
                '}';
    }
    public abstract void ShowInfo();

}
