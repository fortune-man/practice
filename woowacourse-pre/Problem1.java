package onboarding;



import java.util.Comparator;
import java.util.List;

public class Problem1{
    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;
    private static final int RESULT_FIRST_PLAYER_WIN = 1;
    private static final int RESULT_NEXT_PLAYER_WIN = 2;
    private static final int RESULT_EXCEPTION = -1;
    private static final int RESULT_DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // given
        if (!validatePages(pobi) || !validatePages(crong)) {
            return RESULT_EXCEPTION;
        }

        // then
        return playGame(getPlayerScore(pobi), getPlayerScore(crong));
    }


    // 승자를 구하라
    private static int playGame (Integer playerFirst, Integer playerNext) {
        if ( playerFirst > playerNext ) {
            return RESULT_FIRST_PLAYER_WIN;
        }
        if ( playerFirst < playerNext ) {
            return RESULT_NEXT_PLAYER_WIN;
        }
        return RESULT_DRAW;
    }

    // 펼친 페이지에 대한 점수를 구하라
    private static Integer getPlayerScore(List<Integer> player) {
        return player.stream()
                .map(page -> Integer.max(addUnits(page), multiplyUnits(page)))
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException ::new);

    }
    // 각 자리의 합을 구하라
    private static Integer addUnits(Integer page) {
        int result = 0;

        while (page != 0) {
            result += page % 10;
            page /= 10;
        }

        return result;
    }

    // 각 자리의 곱을 구하라
    private static Integer multiplyUnits(Integer page) {
        int result = 1;

        while (page != 0) {
            result *= page % 10;
            page /= 10;
        }

        return result;
    }

    // 유효성을 검사하라
    private static boolean validatePages(List<Integer> pages) {
        Integer leftPage = pages.get(LEFT_PAGE_INDEX);
        Integer rightPage = pages.get(RIGHT_PAGE_INDEX);

        if (!validateRange(leftPage) || !validateRange(rightPage)) {
            return false;
        }

        if (!validateConnectingNumbers(leftPage, rightPage)) {
            return false;
        }

        return validateOdd(leftPage) || validateEven(rightPage);
    }

    // 페이지의 연속 여부를 검증하라
    private static boolean validateConnectingNumbers(Integer leftPage, Integer rightPage) {
        return (leftPage + 1) == rightPage;
    }
    // 입력수가 허용 범위 내에 포함되는지 검사하라
    private static boolean validateRange(Integer page) {
        return MIN_PAGE <= page && page <= MAX_PAGE;
    }

    // 홀수 여부를 검사하라
    private static boolean validateOdd(Integer page){
        return (page % 2) == 1;
    }

    // 짝수 여부를 검사하라
    private static boolean validateEven(Integer page) {
        return (page % 2) == 0;
    }
}


