package org.example;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/30
 * Time: 08:56
 */
public class FileMng {
    public static void write(File file, String s) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(s);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Contact> read(File file) {
        List<Contact> contacts = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int counter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                counter++;
                String[] column = line.split(",");
                if (counter == 1) continue;
                String phone = column[0];
                String group = column[1];
                String name = column[2];
                String gender = column[3];
                String address = column[4];
                String dateOfBirth = column[5];
                String email = column[6];
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date dob = format.parse(dateOfBirth);
                Contact contact = new Contact(phone, group, name, gender, address, dob, email);
                contacts.add(contact);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
}
