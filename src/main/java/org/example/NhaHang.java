package org.example;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/11/01
 * Time: 16:20
 */
public class NhaHang {
    public static void main(String[] args) {
        Thread nhanVien1 = new NhanVienFullTime("Mr. Loc");
        Thread nhanVien2 = new NhanVienFullTime("Mr. Thang");
        System.out.println("NV: " + nhanVien1.getName() + ", trang thai: " + nhanVien1.getState());
        System.out.println("NV: " + nhanVien2.getName() + ", trang thai: " + nhanVien2.getState());

        Runnable nvPartime1 = new NhanVienPartTime("Mr. Tri");
        Thread thread = new Thread(nvPartime1);
        thread.start();
        nhanVien1.start();
        nhanVien2.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello World!" + i);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Runnable " + i);
                }
            }
        }).start();
    }
}
