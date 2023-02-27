package onboarding;


import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    private static final String AT_SIGN = "@";
    private static final String VALID_DOMAIN = "email.com";
    private static final int SPLIT_INDEX = 1;
    private static final int EMAIL_INDEX = 0;
    private static final int NAME_INDEX = 1;
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> separateNameToEmail = new HashMap<>();
        HashSet<String> result = new HashSet<>();

        for (List<String> form : forms) {
            String email = form.get(EMAIL_INDEX);
            String nickName = form.get(NAME_INDEX);

            if(!validateDomain(email)) {
                continue;
            }

            Set<String> invalidEmails = validateDuplicate(separateNameToEmail, email, nickName);
            result.addAll(invalidEmails);
        }

        // 오름차순
        return result.stream()
                .sorted()
                .collect(toList());
    }

    // 문자열을 분리하라
    private static String[] splitString(String string) {
        return string.split(AT_SIGN);
    }

    // 도메인 유효성을 검사하라
    private static boolean validateDomain(String email) {
        String domain = splitString(email)[SPLIT_INDEX];
        return domain.equals(VALID_DOMAIN);
    }

    // 중복을 검사하라
    private static Set<String> validateDuplicate(
            HashMap<String, String> separateNameToEmail,
            String email,
            String nickName) {

        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < nickName.length()-1; i++) {
            String separatedName = nickName.substring(i, i+2);
            String invalidEmail = separateNameToEmail.putIfAbsent(separatedName, email);

            // 중복이 존재하는 경우 결과값에 추가
            if (invalidEmail != null) {
                result.add(invalidEmail);
            }
        }

        if (!result.isEmpty()) {
            result.add(email);
        }

        return result;
    }

}
