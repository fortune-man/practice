package onboarding;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {

    private static final int MIN_POINT = 0;
    private static final int ONE_POINT = 1;
    private static final int MAX_POINT = 10;

    private static final int FIRST_FRIEND = 0;
    private static final int SECOND_FRIEND = 1;

    private static final int RESULT_LIMIT = 5;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> userToFriends = initializeFriendsMap(friends);
        Map<String, Integer> scoreMap = operateFriendsScore(userToFriends, user);

        plusOnePointForVisitors(scoreMap, visitors);

        return convertToResult(scoreMap, new HashSet<>(userToFriends.getOrDefault(user, List.of())), user);
    }

    // 점수 HashMap을 적절한 결과로 변환하라
    private static List<String> convertToResult(Map<String, Integer> scoreMap, HashSet<String> usersFriend, String user) {
        return scoreMap.keySet().stream()
                .filter(friend -> scoreMap.getOrDefault(friend, MIN_POINT) != MAX_POINT)
                .filter(friend -> !usersFriend.contains(friend))
                .filter(friend -> !friend.equals(user))
                .sorted(sortByHighScoreAndLexicographicalOrder(scoreMap))
                .limit(RESULT_LIMIT)
                .collect(toList());
    }

    // 추천 수가 동일한 경우 이름 순서로 정렬하라
    private static Comparator<String> sortByHighScoreAndLexicographicalOrder(Map<String, Integer> scoreMap) {
        return (friend1, friend2) -> {
            int difference = scoreMap.get(friend2) - scoreMap.get(friend1);
            if (difference == 0) {
                return friend1.compareTo(friend2);
            }
            return difference;
        };
    }

    // 친구 관계에 대한 정보를 생성하라
    private static Map<String, List<String>> initializeFriendsMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendsInformation = new HashMap<>();

        for (List<String> friendPair : friends) {
            addFriendsList(friendsInformation, friendPair.get(FIRST_FRIEND), friendPair.get(SECOND_FRIEND));
            addFriendsList(friendsInformation, friendPair.get(SECOND_FRIEND), friendPair.get(FIRST_FRIEND));
        }

        return friendsInformation;
    }

    // 친구 추천 점수를 계산하라 ( 사용자와 함께 아는 친구의 수 )
    private static Map<String, Integer> operateFriendsScore(Map<String, List<String>> friendsInformation, String user) {
        HashMap<String, Integer> scoreMap = new HashMap<>();

        // 사용자와 친구 관계 없는 경우 NPE 발생 방지
        for (String friend : friendsInformation.getOrDefault(user, List.of())) {
            plusMaxPoint(scoreMap, friendsInformation.get(friend));
        }

        return scoreMap;
    }

    private static void plusMaxPoint(HashMap<String, Integer> scoreMap, List<String> friends) {
        for (String friend : friends) {
            Integer score = scoreMap.getOrDefault(friend, MAX_POINT);
            scoreMap.put(friend, score + MAX_POINT);
        }
    }

    // 타임라인 방문자의 점수를 증가시켜라
    private static void plusOnePointForVisitors(Map<String, Integer> scoreMap, List<String> visitors) {
        for (String visitor : visitors) {
            Integer score = scoreMap.getOrDefault(visitor, MIN_POINT);
            scoreMap.put(visitor, score + ONE_POINT);
        }
    }


    private static void addFriendsList(Map<String, List<String>> friendMap, String user, String friend) {
        friendMap.computeIfAbsent(user, key -> new ArrayList<>()).add(friend);
    }

}
