package org.example;

class VongDoiLuong extends Thread {
    public VongDoiLuong(String tenLuong) {
        super(tenLuong);
    }

    @Override
    public void run() {
        System.out.println(getName() + " đang ở trạng thái RUNNABLE.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(getName() + " bị gián đoạn!");
        }
        System.out.println(getName() + " đã hoàn tất và chuyển sang trạng thái TERMINATED.");
    }
}

public class VongDoiDemo {
    public static void main(String[] args) {
        VongDoiLuong luong = new VongDoiLuong("Luồng Demo");

        System.out.println(luong.getName() + " đang ở trạng thái NEW.");
        luong.start();

        // Kiểm tra trạng thái sau khi start
        while (luong.isAlive()) {
            System.out.println(luong.getName() + " đang ở trạng thái " + luong.getState());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread bị gián đoạn!");
            }
        }
        System.out.println(luong.getName() + " đã kết thúc.");
    }
}
