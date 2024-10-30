package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/30
 * Time: 08:49 ${AM_PM}
 */
public class Main {
    public static void main(String[] args) {
        String content = "Hello World!";
        File folder = new File("C:\\Users\\anhnb\\OneDrive\\mywork\\codegym\\02-module-2");
        if (!folder.exists()) { // kiem tra co thu muc hay chua
            folder.mkdir(); // Tao thu muc
        }
        String[] contents = folder.list();
        // Sap xep
//        Arrays.sort(contents, (o1, o2) -> o2.compareTo(o1));
        // In ra file trong thu muc
//        for (String c : contents) {
//            System.out.println(c);
//        }
        File file = new File("data/data.csv");
        System.out.println("Duong dan tuyet doi: " + file.getAbsolutePath()); // Lấy duong dan tuyet doi
        System.out.println("Duong dan tuong doi:" + file.getPath()); // Lay duong dan tuong doi
//        FileMng.write(file, content);

        List<Contact> contacts = FileMng.read(file);
        System.out.println("Tong so danh ba: " + contacts.size());
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}