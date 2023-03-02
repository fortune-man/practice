package Hash;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class 폰켓몬 {


    public class Solution {
        public int solution(int[] nums) {
            // 최대값을 구하라
            int getMaxValue = nums.length / 2;
            int answer = 0;

            /**
             * steram for clean code
             * int[] distinct = Arrays.stream(nums)
             *            .distinct()
             *            .toArray();
             *
             *        int deduplication = distinct.length;
             */


            // 중복 제거 결과를 저장하라
            Set<Integer> distinct = new HashSet<>();

            for (int num : nums) {
                distinct.add(num);
            }

            int deduplication = distinct.size();

            // 최대값과 중복 제거 결과를 비교하라 (둘 중 더 큰 결과를 반환)
            if (getMaxValue > deduplication) {
                answer = deduplication;
            } else {
                answer = getMaxValue;
            }

            return answer;

        }

    }
}
