package Utilies;

import java.util.Random;

public class RandomCreator {


    public static String randomEmailCreator(){

        String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        java.util.Random rnd = new java.util.Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String email = salt.toString() + "@testeremre.com";
        return email;
    }

    public static String randomNameCreator(int length){
        String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        java.util.Random rnd = new java.util.Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String name = salt.toString() ;
        return name;
    }

    public static String randomPasswordCreator(int length){
        String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890+()=/&%";
        StringBuilder salt = new StringBuilder();
        java.util.Random rnd = new java.util.Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String pass = salt.toString() ;
        return pass;
    }
}
