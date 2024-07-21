package kz.roman.shelter.utils;

import lombok.experimental.UtilityClass;
import java.util.Random;

@UtilityClass
public class RandomUtil {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int STRING_LENGTH = 4;

    public static int generateRandomNumber(int from, int to) {
        if (from >= to) {
            throw new IllegalArgumentException("Invalid range: 'from' must be less than 'to'");
        }

        Random random = new Random();
        return random.nextInt(to - from + 1) + from;
    }

    public static String generateRandomCode() {
        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        Random random = new Random();
        for (int i = 0; i < STRING_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
