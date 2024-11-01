package org.example;

class KhoChua {
    private int soLuongBanh = 0;
    private final int sucChua = 5;

    public synchronized void sanXuatBanh() throws InterruptedException {
        while (soLuongBanh >= sucChua) {
            System.out.println("Kho da day. Cho khach hang mua banh...");
            wait();
        }
        soLuongBanh++;
        System.out.println("San xuat banh. So luong banh trong kho: " + soLuongBanh);
        notify();
    }

    public synchronized void muaBanh() throws InterruptedException {
        while (soLuongBanh <= 0) {
            System.out.println("Kho rong. Cho san xuat them banh...");
            wait();
        }
        soLuongBanh--;
        System.out.println("Khach hang mua banh. So luong banh trong kho: " + soLuongBanh);
        notify();
    }
}

class Producer extends Thread {
    private KhoChua kho;

    public Producer(KhoChua kho) {
        this.kho = kho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                kho.sanXuatBanh();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer bị gián đoạn");
        }
    }
}

class Consumer extends Thread {
    private KhoChua kho;

    public Consumer(KhoChua kho) {
        this.kho = kho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                kho.muaBanh();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer bị gián đoạn");
        }
    }
}

public class DemoWaitNotify {
    public static void main(String[] args) {
        KhoChua kho = new KhoChua();
        Producer producer = new Producer(kho);
        Consumer consumer = new Consumer(kho);

        producer.start();
        consumer.start();
    }
}
