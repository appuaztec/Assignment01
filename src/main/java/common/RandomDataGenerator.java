package common;

import java.util.Random;

public class RandomDataGenerator {

    public static int getRandomNum(int min, int max) {
        String res = null;
        Random random = new Random();
        int ranNum = random.nextInt(max - min + 1) + min;
        return ranNum;
    }

    public static String getRandomWord(int length) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String res = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int ranNum = random.nextInt(alpha.length() - 1 + 1) + 1;
            res = res + alpha.charAt(ranNum);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(getRandomNum(11111, 99999));
    }
}
