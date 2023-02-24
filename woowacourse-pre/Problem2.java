package onboarding;


import java.util.ArrayDeque;
import java.util.regex.Pattern;

public class Problem2 {
    // given
    private static final Pattern CONSECUTIVE_DUPLICATE_CHARACTERS = Pattern.compile("(.)\\1+");
    private static final String NULL_STRING = "";
    public static String solution(String cryptogram) {

        // then
        return decrypt(cryptogram);

    }

    // when : 암호를 해독하라
    // 중복 제거된 결과 반환을 재귀 호출하라
    private static String decrypt(String cryptogram) {
        String decode = removeDuplicate(cryptogram);

        if (decode.equals(cryptogram)) {
            return decode;
        }

        return decrypt(decode);
    }

    // 중복을 제거하라
    private static String removeDuplicate(String cryptogram) {
        return CONSECUTIVE_DUPLICATE_CHARACTERS.matcher(cryptogram).replaceAll(NULL_STRING);
    }
}


