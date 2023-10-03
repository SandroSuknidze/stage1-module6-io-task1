package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {

        String content = "";
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int character;
            while ((character = fileInputStream.read()) != -1) {
                content += (char) character;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] lines = content.split("\n");
        Profile profile = new Profile();

        for (String line : lines) {
            String[] keyValue = line.split(": ");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];

                switch (key) {
                    case "Name":
                        profile.setName(value);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email":
                        profile.setEmail(value);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(value));
                        break;
                    default:
                        break;
                }
            }
        }


        return new Profile();
    }
}
