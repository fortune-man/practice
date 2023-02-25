package onboarding;


import java.util.stream.IntStream;

public class Problem3 {
    private static final int START_NUMBER = 1;
    private static final int THREE = 3;
    private static final int SIX = 6;
    private static final int NINE = 9;

    public static int solution(int number) {

        // then : number 까지의 총 합 구하기
        return IntStream.range(START_NUMBER, number + 1)
                .map(Problem3::getClapCount)
                .sum();
    }

    // given : 박수의 수를 구하라
    private static int getClapCount(int number) {
        int count = 0;

        while (number != 0) {
            int clap = number % 10;
            if (clap == THREE || clap == SIX || clap == NINE) {
                count += 1;
            }
            number /= 10;
        }

        return count;
    }
}
