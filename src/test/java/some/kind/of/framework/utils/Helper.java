package some.kind.of.framework.utils;

import java.util.Random;

public class Helper {

    public static String getRandomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String getRandomEmail(int length) {
        return getRandomString(10) + "@some.domain";
    }
}
