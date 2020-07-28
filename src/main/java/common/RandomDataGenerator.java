package common;

import java.util.Random;

public class RandomDataGenerator {

    public static int getRandomNum(int min, int max) {
        String res = null;
        Random random = new Random();
        int ranNum = random.nextInt(max - min + 1) + min;
        return ranNum;
    }

    public static void main(String[] args) {
        System.out.println(getRandomNum(11111, 99999));
    }
}
