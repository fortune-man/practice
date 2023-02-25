package onboarding;

import java.util.HashMap;

public class Problem4 {

    private static final HashMap<Character, Character> FROG_MAP = new HashMap<>();
    public static String solution(String word) {
        // given
        createFrogMap();

        // then
        return reverseWord(word);

    }


    // 청개구리 사전을 생성하라
    private static void createFrogMap() {
        char upperCaseA = 'A';
        char upperCaseZ = 'Z';
        char lowerCaseA = 'a';
        char lowerCaseZ = 'z';

        for (int i = 0; i < 26; i++) {
            FROG_MAP.put(upperCaseA++, upperCaseZ--);
            FROG_MAP.put(lowerCaseA++, lowerCaseZ--);
        }
    }
    
    // 단어를 반대로 변환하라
    private static String reverseWord(String word) {
        StringBuilder result = new StringBuilder();

        for (char letter : word.toCharArray()) {
            result.append(getFrogMapOrDefault(letter));
        }

        return result.toString();
    }

    // 함수 분리
    private static Character getFrogMapOrDefault(char letter) {
        return FROG_MAP.getOrDefault(letter, letter);
    }

}
