package lottogame.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static int nextInt(int range) {
        return RANDOM.nextInt(range);
    }
}
