package org.example;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/11/01
 * Time: 16:35
 */
public class NhanVienPartTime implements Runnable {

    private String tenNhanVien;

    public NhanVienPartTime(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    @Override
    public void run() {
        System.out.println("Nhan vien " + getTenNhanVien() + " dang o trang thai " + Thread.currentThread().getState());
        for (int i = 1; i <= 3; i++) {
            System.out.println("Nhan vien " + getTenNhanVien() + " dang phuc vu ban so " + i + ", trang thai " + Thread.currentThread().getState());
            try {
                Thread.sleep(1000);
//                wait(1000);
            } catch (InterruptedException e) {
                System.out.println("Nhan vien bi gian doan");
            }
//            notify();
        }
        System.out.println("Nhan vien " + getTenNhanVien() + " Da phuc vu xong" + Thread.currentThread().getState());
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
}
