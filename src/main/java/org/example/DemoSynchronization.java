package org.example;

class TaiKhoan {
    private int soDu = 100;

    public synchronized void rutTien(int soTien) {
        if (soDu >= soTien) {
            System.out.println(Thread.currentThread().getName() + " đang rút " + soTien + " đồng.");
            soDu -= soTien;
            System.out.println("Số dư còn lại sau khi " + Thread.currentThread().getName() + " rút: " + soDu + " đồng.");
        } else {
            System.out.println("Số dư không đủ cho " + Thread.currentThread().getName() + " để rút " + soTien + " đồng.");
        }
    }
}

class KhachHang extends Thread {
    private TaiKhoan taiKhoan;
    private int soTienRut;

    public KhachHang(TaiKhoan taiKhoan, int soTienRut) {
        this.taiKhoan = taiKhoan;
        this.soTienRut = soTienRut;
    }

    @Override
    public void run() {
        taiKhoan.rutTien(soTienRut);
    }
}

public class DemoSynchronization {
    public static void main(String[] args) {
        TaiKhoan taiKhoan = new TaiKhoan();

        KhachHang khachHang1 = new KhachHang(taiKhoan, 80);
        KhachHang khachHang2 = new KhachHang(taiKhoan, 50);

        khachHang1.setName("Khách hàng 1");
        khachHang2.setName("Khách hàng 2");

        khachHang1.start();
        khachHang2.start();
    }
}
